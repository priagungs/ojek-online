package com.future.ojekonline.repository;

import com.future.ojekonline.entity.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, String> {
    Page<Driver> findAllByAvailabilityIsTrue(Pageable pageable);
    Optional<Driver> findById(String id);
}
