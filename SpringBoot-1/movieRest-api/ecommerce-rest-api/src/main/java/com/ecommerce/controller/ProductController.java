package com.ecommerce.controller;
import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired ProductService service;

    @GetMapping("/add")
    public String addForm(Model m){
        m.addAttribute("product", new Product());
        return "product-add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Product product){
        service.save(product);
        return "redirect:/product/list";
    }

    @GetMapping("/list")
    public String list(Model m){
        m.addAttribute("products", service.list());
        return "product-list";
    }
}
