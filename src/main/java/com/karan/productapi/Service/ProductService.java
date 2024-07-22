package com.karan.productapi.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karan.productapi.Model.Product;
import com.karan.productapi.Repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // Method to get products based on various filters and sorting options
    public List<Product> getProducts(String category, Double minPrice, Double maxPrice, Boolean inStock, String sortField, String sortOrder) {
        List<Product> products = new ArrayList<>();

        // Filter products by category if provided
        if (category != null) {
            products = productRepository.findByCategory(category);
        // Filter products by price range if provided
        } else if (minPrice != null && maxPrice != null) {
            products = productRepository.findByPriceBetween(minPrice, maxPrice);
        // Filter products by stock status if provided
        } else if (inStock != null) {
            products = productRepository.findByInStock(inStock);
        // Get all products if no filters are provided
        } else {
            products = productRepository.findAll();
        }

        // Sort the products if sortField and sortOrder are provided
        if (sortField != null && sortOrder != null) {
            if (sortField.equals("price")) {
                // Sort products by price in ascending or descending order
                if (sortOrder.equals("asc")) {
                    products.sort(Comparator.comparingDouble(Product::getPrice));
                } else {
                    products.sort(Comparator.comparingDouble(Product::getPrice).reversed());
                }
            } else if (sortField.equals("rating")) {
                // Sort products by rating in ascending or descending order
                if (sortOrder.equals("asc")) {
                    products.sort(Comparator.comparingDouble(Product::getRating));
                } else {
                    products.sort(Comparator.comparingDouble(Product::getRating).reversed());
                }
            } else if (sortField.equals("createdAt")) {
                // Sort products by creation date in ascending or descending order
                if (sortOrder.equals("asc")) {
                    products.sort(Comparator.comparing(Product::getCreatedAt));
                } else {
                    products.sort(Comparator.comparing(Product::getCreatedAt).reversed());
                }
            }
        }

        return products;
    }
}
