package com.karan.productapi.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.karan.productapi.Model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
    // Find products by category.
    List<Product> findByCategory(String category);

    // Find products with price between minPrice and maxPrice.
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    // Find products based on inStock status.
    List<Product> findByInStock(boolean inStock);
}
