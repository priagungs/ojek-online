package com.future.ojekonline.service;

import com.future.ojekonline.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer readCustomer(String id);
}
