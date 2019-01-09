package com.future.ojekonline.service;

import com.future.ojekonline.entity.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface DriverService {

    Page<Driver> getDrivers(Pageable pageable);
    Page<Driver> getAvailableDrivers(Pageable pageable);
    Driver createDriver(Driver driver);
    Driver getDriver(String id);
    Boolean deleteDriver(String id);
    Driver updateDriver(Driver driver);

}
