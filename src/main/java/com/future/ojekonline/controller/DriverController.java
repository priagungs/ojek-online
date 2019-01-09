package com.future.ojekonline.controller;

import com.future.ojekonline.entity.Driver;
import com.future.ojekonline.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DriverController {

    @Autowired
    DriverService driverService;

    @GetMapping("/drivers")
    Page<Driver> getDrivers(@RequestParam(name = "page") Integer page,
                            @RequestParam(name = "limit") Integer limit,
                            @RequestParam(name = "sort") String sort) {
        return driverService.getDrivers(
                new PageRequest(page, limit, Sort.Direction.ASC, sort));
    }

    @PostMapping("/drivers")
    Driver createDriver(@RequestBody Driver driver) {
        return driverService.createDriver(driver);
    }

}
