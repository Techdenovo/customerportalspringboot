package com.techdenovo.app.customerportalspringboot.service;

import com.techdenovo.app.customerportalspringboot.domain.Customer;
import com.techdenovo.app.customerportalspringboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }
    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElse(null);
    }

    public Customer updateCustomer(Customer customer, Long id){
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        if (existingCustomer != null){
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setEmailId(customer.getEmailId());
        }
        return customerRepository.save(existingCustomer);
    }
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }
}
