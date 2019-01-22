package com.future.ojekonline.repository;

import com.future.ojekonline.entity.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findById(String id);
    Optional<Customer> findByUsername(String username);
}
