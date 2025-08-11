package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.AppointmentService;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        AppointmentService appointmentService = (AppointmentService) context.getBean("appointmentService");

        String result = appointmentService.book("DOC101", "2025-04-10");
        System.out.println(result); 
    }
}
