package com.example.jdbc.domain.customer;

import com.example.jdbc.api.customer.CustomerAddressRequest;
import com.example.jdbc.api.customer.CustomerRequest;
import com.example.jdbc.domain.exception.DomainException;
import com.example.jdbc.domain.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final CustomerRepository repository;

  public CustomerEntity findById(final UUID customerId) {
    var customer = repository.findById(customerId);

    return customer.orElseThrow(() -> new NotFoundException("Customer not found"));
  }

  public CustomerEntity findByRegistrationNumber(final String registrationNumber) {
    var customer = repository.findByRegistrationNumber(registrationNumber);

    return customer.orElseThrow(() -> new NotFoundException("Customer not found"));
  }

  public CustomerEntity create(final CustomerRequest request) {
    var result = repository.findByRegistrationNumber(request.getRegistrationNumber());

    if (result.isPresent()) {
      throw new DomainException("Registration number already exists");
    }

    var entity = buildEntity(request);

    return repository.save(entity);
  }

  private CustomerEntity buildEntity(final CustomerRequest request) {
    return CustomerEntity.builder()
        .name(request.getName())
        .registrationNumber(request.getRegistrationNumber())
        .addresses(
            request.getAddresses().stream()
                .map(this::buildAddressEntity)
                .collect(Collectors.toSet()))
        .build();
  }

  private CustomerAddressEntity buildAddressEntity(CustomerAddressRequest request) {
    return CustomerAddressEntity.builder()
        .address(request.getAddress())
        .number(request.getNumber())
        .build();
  }
}
