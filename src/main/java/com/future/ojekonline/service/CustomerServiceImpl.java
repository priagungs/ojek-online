package com.future.ojekonline.service;

import com.future.ojekonline.entity.Customer;
import com.future.ojekonline.repository.CustomerRepository;
import com.future.ojekonline.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    public Customer createCustomer(Customer customer) {
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
}
