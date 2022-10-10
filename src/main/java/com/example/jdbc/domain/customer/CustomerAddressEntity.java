package com.example.jdbc.domain.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@Table("customer_address")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddressEntity implements Persistable<UUID> {
  @Id
  @Column("customer_address_id")
  private UUID id;

  @Column("address")
  private String address;

  @Column("number")
  private Integer number;

  @Override
  public boolean isNew() {
    return Objects.isNull(this.id);
  }
}
