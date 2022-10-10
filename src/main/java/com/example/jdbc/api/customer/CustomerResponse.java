package com.example.jdbc.api.customer;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class CustomerResponse {
  private UUID id;
  private String name;
  private String registrationNumber;
  private Set<CustomerAddressResponse> addresses;
}
