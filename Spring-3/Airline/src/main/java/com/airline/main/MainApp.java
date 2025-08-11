package com.airline.main;

import com.airline.service.TicketService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("airline-context.xml");

        TicketService ticketService = (TicketService) context.getBean("ticketService");

        // Test bookings
        System.out.println(ticketService.confirmBooking("FL123", "USER456")); 
        System.out.println(ticketService.confirmBooking("FL123", "USER789")); 
        System.out.println(ticketService.confirmBooking("FL123", "USER000")); 
        System.out.println(ticketService.confirmBooking("FL456", "USER111")); 
    }
}
