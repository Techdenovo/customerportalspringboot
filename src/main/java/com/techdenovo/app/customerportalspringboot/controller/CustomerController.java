package com.techdenovo.app.customerportalspringboot.controller;

import com.techdenovo.app.customerportalspringboot.domain.Customer;
import com.techdenovo.app.customerportalspringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listCustomers",customerService.getAllCustomers());
        return "index";
    }
    @GetMapping("/showNewCustomerForm")
    public String showNewCustomerForm(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "add-customer";
    }
}
