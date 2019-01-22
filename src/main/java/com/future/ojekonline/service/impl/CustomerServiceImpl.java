package com.future.ojekonline.service.impl;

import com.future.ojekonline.entity.model.Customer;
import com.future.ojekonline.repository.CustomerRepository;
import com.future.ojekonline.service.exception.InvalidValueException;
import com.future.ojekonline.service.exception.NotFoundException;
import com.future.ojekonline.service.interf.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public Customer createCustomer(Customer customer) {
        if (repository.findByUsername(customer.getUsername()).isPresent()) {
            throw new InvalidValueException("username already exists");
        }
        return repository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if (repository.findById(customer.getId()).isPresent()) {
            return repository.save(customer);
        }
        else {
            throw new NotFoundException("customer not found");
        }
    }

    @Override
    public Customer readCustomer(String id) {
        return repository.findById(id)
                .orElseThrow(()-> new NotFoundException("customer not found"));
    }

    @Override
    public Customer readCustomerByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("customer not found"));
    }

    @Override
    public Boolean deleteCustomer(String id) {
    if (!repository.findById(id).isPresent()) {
            throw new NotFoundException("driver not found");
        }
        repository.delete(id);
        return true;
    }
}
