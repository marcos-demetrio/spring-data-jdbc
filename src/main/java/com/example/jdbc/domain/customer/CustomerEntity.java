package com.example.jdbc.domain.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@Table("customer")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity implements Persistable<UUID> {
  @Id
  @Column("customer_id")
  private UUID id;

  @Column("name")
  private String name;

  @Column("registration_number")
  private String registrationNumber;

  @MappedCollection(idColumn = "customer_id", keyColumn = "customer_id")
  private List<CustomerAddressEntity> addresses;

  @Override
  public boolean isNew() {
    return Objects.isNull(this.id);
  }
}
