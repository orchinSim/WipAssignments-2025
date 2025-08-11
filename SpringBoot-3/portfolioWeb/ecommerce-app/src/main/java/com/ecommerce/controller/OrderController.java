package com.ecommerce.controller;
import com.ecommerce.model.Order;
import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired OrderService service;

    @GetMapping("/add")
    public String addForm(Model m){
        m.addAttribute("order", new Order());
        return "order-add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Order order){
        service.save(order);
        return "redirect:/order/list";
    }

    @GetMapping("/list")
    public String list(Model m){
        m.addAttribute("orders", service.list());
        return "order-list";
    }
}
