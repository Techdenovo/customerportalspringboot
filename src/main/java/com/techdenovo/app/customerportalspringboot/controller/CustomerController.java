package com.techdenovo.app.customerportalspringboot.controller;

import com.techdenovo.app.customerportalspringboot.domain.Customer;
import com.techdenovo.app.customerportalspringboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

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

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.addCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {

        // get employee from the service
        Customer customer = customerService.getCustomerById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("customer", customer);
        return "update-customer";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id) {

        // call delete employee method
        this.customerService.deleteCustomer(id);
        return "redirect:/";
    }
}
