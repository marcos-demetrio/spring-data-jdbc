package com.example.jdbc.domain.customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, UUID> {
  Optional<CustomerEntity> findByRegistrationNumber(String registrationNumber);
}
