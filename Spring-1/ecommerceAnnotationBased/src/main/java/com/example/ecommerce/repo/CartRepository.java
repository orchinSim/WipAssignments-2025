package com.example.ecommerce.repo;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CartRepository {
    // Simulated carts (cartId -> list of itemIds)
    private final Map<String, List<String>> carts = new HashMap<>();

    public CartRepository() {
        
        carts.put("CART001", Arrays.asList("ITEM001", "ITEM002"));
        carts.put("CART002", Collections.singletonList("ITEM003"));
        carts.put("EMPTY_CART", Collections.emptyList());
        
    }

    public List<String> getItems(String cartId) {
        return carts.get(cartId);
    }

    public boolean exists(String cartId) {
        return carts.containsKey(cartId);
    }

    
    public void clearCart(String cartId) {
        carts.remove(cartId);
    }
}
