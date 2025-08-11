package com.example.ecommerce.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.ecommerce.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final Map<String, Integer> stock = new HashMap<>();

    @PostConstruct
    public void init() {
        
        stock.put("ITEM001", 5);
        stock.put("ITEM002", 0); 
        stock.put("ITEM003", 2);
    }

    @Override
    public boolean isAvailable(String itemId) {
        Integer qty = stock.get(itemId);
        return qty != null && qty > 0;
    }
    public boolean reserve(String itemId) {
        Integer qty = stock.get(itemId);
        if (qty == null || qty <= 0) return false;
        stock.put(itemId, qty - 1);
        return true;
    }
}
