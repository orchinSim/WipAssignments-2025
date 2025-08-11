package com.ecommerce.controller;
import com.ecommerce.model.Customer;
import com.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired CustomerService service;

    @GetMapping("/add")
    public String addForm(Model m){
        m.addAttribute("customer", new Customer());
        return "customer-add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Customer customer){
        service.save(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/list")
    public String list(Model m){
        m.addAttribute("customers", service.list());
        return "customer-list";
    }
    
    @GetMapping("/edit/{id}")
    public String editCustomer(@PathVariable Long id, Model model) {
        model.addAttribute("customer", service.getCustomerById(id));
        return "customer-add";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
    	service.deleteCustomerById(id);
        return "redirect:/customer/list";
    }

}