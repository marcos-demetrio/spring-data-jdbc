package com.example.jdbc.api.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
  private String name;
  private String registrationNumber;
  private Set<CustomerAddressRequest> addresses;
}
