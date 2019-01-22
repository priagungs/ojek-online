package com.future.ojekonline.repository;

import com.future.ojekonline.entity.model.Booking;
import com.future.ojekonline.entity.model.Customer;
import com.future.ojekonline.entity.model.Driver;
import com.future.ojekonline.entity.model.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, String> {

    Optional<Booking> findById(String id);
    Page<Booking> findAllByCustomer(Customer customer, Pageable pageable);
    Page<Booking> findAllByStatus(Status status, Pageable pageable);
    Page<Booking> findAllByDriver(Driver driver, Pageable pageable);

}
