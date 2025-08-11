package com.ecommerce.controller;
import com.ecommerce.model.Payment;
import com.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    @Autowired PaymentService service;

    @GetMapping("/add")
    public String addForm(Model m){
        m.addAttribute("payment", new Payment());
        return "payment-add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Payment payment){
        service.save(payment);
        return "redirect:/payment/list";
    }

    @GetMapping("/list")
    public String list(Model m){
        m.addAttribute("payments", service.list());
        return "payment-list";
    }
    
    @GetMapping("/edit/{id}")
    public String editPayment(@PathVariable Long id, Model model) {
        Payment payment = service.getPaymentById(id);
        model.addAttribute("payment", payment);
        return "payment-add"; // reuse same form
    }

    @GetMapping("/delete/{id}")
    public String deletePayment(@PathVariable Long id) {
        service.deletePaymentById(id);
        return "redirect:/payment/list";
    }
}