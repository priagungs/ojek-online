package com.future.ojekonline.service;

import com.future.ojekonline.entity.Driver;
import com.future.ojekonline.repository.DriverRepository;
import com.future.ojekonline.service.exception.InvalidValueException;
import com.future.ojekonline.service.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepository repository;

    @Override
    public Page<Driver> getDrivers(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<Driver> getAvailableDrivers(Pageable pageable) {
        return repository.findAllByAvailabilityIsTrue(pageable);
    }

    @Override
    public Driver createDriver(Driver driver) {
        return repository.save(driver);
    }

    @Override
    public Driver getDriver(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("driver not found"));
    }

    @Override
    public Boolean deleteDriver(String id) {
        repository.delete(id);
        return true;
    }

    @Override
    public Driver updateDriver(Driver driver) {
        if (repository.findById(driver.getId()).isPresent()) {
            return repository.save(driver);
        }
        else {
            throw new NotFoundException("driver not found");
        }
    }
}
