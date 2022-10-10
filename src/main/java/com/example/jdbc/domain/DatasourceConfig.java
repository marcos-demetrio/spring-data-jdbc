package com.example.jdbc.domain;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatasourceConfig {

  @Bean
  @Primary
  @ConfigurationProperties("app.datasource.postgres")
  public HikariDataSource hikariDataSource() {
    return DataSourceBuilder.create().type(HikariDataSource.class).build();
  }

  @Bean
  public JdbcTemplate jdbcTemplate(HikariDataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
}
