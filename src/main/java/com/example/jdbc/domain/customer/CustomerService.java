package com.example.jdbc.domain.customer;

import com.example.jdbc.domain.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
}
