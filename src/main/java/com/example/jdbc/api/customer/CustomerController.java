package com.example.jdbc.api.customer;

import com.example.jdbc.domain.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
  private final CustomerService service;

  @GetMapping("{customerId}")
  public ResponseEntity<CustomerResponse> findById(
      @PathVariable("customerId") final UUID customerId) {
    var entity = service.findById(customerId);

    var response = CustomerMapper.toResponse(entity);

    return ResponseEntity.ok(response);
  }

  @GetMapping("registration-number/{registrationNumber}")
  public ResponseEntity<CustomerResponse> findByRegistrationNumber(
      @PathVariable("registrationNumber") final String registrationNumber) {
    var entity = service.findByRegistrationNumber(registrationNumber);

    var response = CustomerMapper.toResponse(entity);

    return ResponseEntity.ok(response);
  }

  @PostMapping
  public ResponseEntity<CustomerResponse> create(@Valid @RequestBody CustomerRequest request) {
    var entity = service.create(request);

    var response = CustomerMapper.toResponse(entity);

    return ResponseEntity.status(CREATED).body(response);
  }
}
