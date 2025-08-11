package com.example.product_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product_service.model.Product;
import com.example.product_service.repository.ProductRepository;

@Service
public class ProductService {
	
	 @Autowired
	    private ProductRepository productRepository;

	    public Product createProduct(Product product) {
	        return productRepository.save(product);
	    }
	    
	    public List<Product> getAllProducts() {
			// TODO Auto-generated method stub
			return productRepository.findAll();
		}

	    public Product getProductById(Long id) {
	    	
	        return productRepository.findById(id).orElse(null);
	    }
	    
	    public Product getProductByName(String name) {
	        return productRepository.findByName(name).orElse(null);
	    }
}

