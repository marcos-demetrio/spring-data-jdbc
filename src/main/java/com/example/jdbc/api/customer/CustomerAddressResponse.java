package com.example.jdbc.api.customer;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CustomerAddressResponse {
  private UUID id;
  private String address;
  private Integer number;
}
