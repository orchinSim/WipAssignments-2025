package com.example.ecommerce.service.impl;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.repo.CartRepository;
import com.example.ecommerce.service.CartValidator;
import com.example.ecommerce.service.InventoryService;
import com.example.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private final CartValidator cartValidator;
    private final InventoryService inventoryService;
    private final CartRepository cartRepository;

    @Autowired
    public OrderServiceImpl(CartValidator cartValidator, InventoryService inventoryService, CartRepository cartRepository) {
        this.cartValidator = cartValidator;
        this.inventoryService = inventoryService;
        this.cartRepository = cartRepository;
    }
    
    @Override
    public String checkout(String cartId) {
        boolean valid = cartValidator.validateCart(cartId);
        if (!valid) {
            return "Cart is invalid";
        }
        List<String> items = cartRepository.getItems(cartId);
        for (String itemId : items) {
            if (!inventoryService.isAvailable(itemId)) {
                return "Item out of stock";
            }
        }
        if (inventoryService instanceof InventoryServiceImpl) {
            InventoryServiceImpl impl = (InventoryServiceImpl) inventoryService;
            for (String itemId : items) {
                boolean reserved = impl.reserve(itemId);
                if (!reserved) {
                    return "Item out of stock";
                }
            }
        }
        Order order = new Order(UUID.randomUUID().toString(), items);
        cartRepository.clearCart(cartId);
        return "Checkout successful for " + cartId;
    }
}
