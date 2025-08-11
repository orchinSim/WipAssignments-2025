package com.example.ecommerce;

import com.example.ecommerce.config.AppConfig;
import com.example.ecommerce.service.OrderService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = ctx.getBean(OrderService.class);

        String result1 = orderService.checkout("CART001");
        System.out.println(result1); // "Item out of stock"

        
        String result2 = orderService.checkout("CART002");
        System.out.println(result2); 

        
        String result3 = orderService.checkout("NON_EXISTENT");
        System.out.println(result3); 

        ctx.close();
    }
}
