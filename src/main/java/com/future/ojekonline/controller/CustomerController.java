package com.future.ojekonline.controller;

import com.future.ojekonline.entity.model.Customer;
import com.future.ojekonline.entity.model.Driver;
import com.future.ojekonline.entity.response.BaseResponse;
import com.future.ojekonline.service.exception.InvalidValueException;
import com.future.ojekonline.service.exception.NotFoundException;
import com.future.ojekonline.service.interf.CustomerService;
import com.future.ojekonline.service.interf.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers/{id}")
    BaseResponse<Customer> getCustomer(@PathVariable(name = "id") String id) {
        Customer result;
        BaseResponse<Customer> response = new BaseResponse<>();
        try {
            result = customerService.readCustomer(id);
        }
        catch (NotFoundException e) {
            response.setStatus(404);
            response.setMessage(e.getMessage());
            return response;
        }
        response.setStatus(200);
        response.setMessage("Success");
        response.setPayload(result);
        return response;
    }

    @PostMapping("/customers")
    BaseResponse<Customer> createCustomer(@RequestBody Customer customer) {
        Customer result;
        BaseResponse<Customer> response = new BaseResponse<>();
        try {
            result = customerService.createCustomer(customer);
        }
        catch (InvalidValueException e) {
            response.setStatus(400);
            response.setMessage(e.getMessage());
            return response;
        }
        response.setStatus(200);
        response.setMessage("Success");
        response.setPayload(result);
        return response;
    }

    @PutMapping("/drivers/{id}")
    BaseResponse<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable(name = "id") String id) {
        Customer result;
        BaseResponse<Customer> response = new BaseResponse<>();
        try {
            result = customerService.updateCustomer(customer);
        }
        catch (NotFoundException e) {
            response.setStatus(404);
            response.setMessage(e.getMessage());
            return response;
        }
        response.setPayload(result);
        response.setMessage("Success");
        response.setStatus(200);
        return response;
    }

    @DeleteMapping("/drivers/{id}")
    BaseResponse<Customer> deleteCustomer(@PathVariable(name = "id") String id) {
        BaseResponse<Customer> response = new BaseResponse<>();
        try {
            customerService.deleteCustomer(id);
        }
        catch (NotFoundException e) {
            response.setStatus(404);
            response.setMessage(e.getMessage());
            return response;
        }
        response.setStatus(200);
        response.setMessage("Success");
        return response;
    }

}
