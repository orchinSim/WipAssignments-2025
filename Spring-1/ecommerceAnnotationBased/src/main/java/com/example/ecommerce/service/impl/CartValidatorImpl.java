package com.example.ecommerce.service.impl;

import com.example.ecommerce.repo.CartRepository;
import com.example.ecommerce.service.CartValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartValidatorImpl implements CartValidator {

    private final CartRepository cartRepository;

    @Autowired
    public CartValidatorImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public boolean validateCart(String cartId) {
        if (!cartRepository.exists(cartId)) return false;
        List<String> items = cartRepository.getItems(cartId);
        return items != null && !items.isEmpty();
    }
}
