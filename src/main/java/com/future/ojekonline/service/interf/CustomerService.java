package com.future.ojekonline.service.interf;

import com.future.ojekonline.entity.model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer readCustomer(String id);
    Customer readCustomerByUsername(String username);
    Boolean deleteCustomer(String id);
}
