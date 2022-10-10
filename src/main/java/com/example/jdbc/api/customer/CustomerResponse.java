package com.example.jdbc.api.customer;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class CustomerResponse {
  private UUID id;
  private String name;
  private List<CustomerAddressResponse> addresses;
}
