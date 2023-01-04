package com.example.springbotblogrestapi.service;

import com.example.springbotblogrestapi.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}
