package org.example.controller;

import org.example.entity.Customer;
import org.example.service.CustomerService;

import java.util.List;

public class CustomerController {
    private CustomerService customerService;

    public CustomerController() {
        customerService= new CustomerService();
    }

    public void showAllPerson(){
        List<Customer> customerList= customerService.findAll();
        for (Customer customer: customerList) {
            System.out.println(customer);
        }


    }
}
