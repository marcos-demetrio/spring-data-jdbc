package com.example.jdbc.api.customer;

import com.example.jdbc.domain.customer.CustomerAddressEntity;
import com.example.jdbc.domain.customer.CustomerEntity;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;

@UtilityClass
public class CustomerMapper {

  public CustomerResponse toResponse(final CustomerEntity entity) {
    return CustomerResponse.builder()
        .id(entity.getId())
        .name(entity.getName())
        .addresses(
            entity.getAddresses().stream()
                .map(CustomerMapper::toResponse)
                .collect(Collectors.toList()))
        .build();
  }

  private CustomerAddressResponse toResponse(final CustomerAddressEntity entity) {
    return CustomerAddressResponse.builder()
        .id(entity.getId())
        .address(entity.getAddress())
        .number(entity.getNumber())
        .build();
  }
}
