package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Passport;
import org.example.repository.CustomerRepository;
import org.example.repository.PassportRepository;

import java.util.List;

public class CustomerService {
    private CustomerRepository customerRepository;
    private PassportRepository passportRepository;

    public CustomerService() {
        customerRepository=new CustomerRepository();
        passportRepository=new PassportRepository();
    }

    public List<Customer> findAll() {
        List<Customer>  customerList= customerRepository.findAll();
        for (Customer customer: customerList) {
            Passport byId= passportRepository.findById(customer.getPassport().getId);
            customer.setPassport(byId);
        }
        return customerList;
    }
}
