package com.future.ojekonline.service.impl;

import com.future.ojekonline.entity.model.Booking;
import com.future.ojekonline.repository.BookingRepository;
import com.future.ojekonline.service.interf.BookingService;
import com.future.ojekonline.service.exception.NotFoundException;
import com.future.ojekonline.service.interf.CustomerService;
import com.future.ojekonline.service.interf.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository repository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DriverService driverService;


    @Override
    public Booking createBooking(Booking booking) {
        if (booking.getBookTime() == null) {
            booking.setBookTime(new Date());
        }
        return repository.save(booking);
    }

    @Override
    public Page<Booking> getBookingByCustomer(String id, Pageable pageable) {
        return repository.findAllByCustomer(customerService.readCustomer(id), pageable);
    }

    @Override
    public Page<Booking> getBookingByDriver(String id, Pageable pageable) {
        return repository.findAllByDriver(driverService.getDriver(id), pageable);
    }

    @Override
    public Booking updateBooking(Booking booking) {
        if (!repository.findById(booking.getId()).isPresent()) {
            throw new NotFoundException("booking is not found");
        }
        return repository.save(booking);
    }

    @Override
    public Boolean deleteBooking(String id) {
        if (!repository.findById(id).isPresent()) {
            throw new NotFoundException("booking is not found");
        }
        repository.delete(id);
        return true;
    }
}
