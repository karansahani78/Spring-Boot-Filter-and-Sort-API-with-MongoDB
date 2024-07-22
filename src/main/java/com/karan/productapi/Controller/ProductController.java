package com.karan.productapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karan.productapi.Model.Product;
import com.karan.productapi.Service.ProductService;

@RestController // Indicates that this class is a REST controller and its methods will handle HTTP requests
@RequestMapping("/api") // Maps HTTP requests to /api URL to this controller
public class ProductController {

    @Autowired // Injects the ProductService bean into this controller
    private ProductService productService;

    @GetMapping("/products") // Maps GET requests to /api/products URL to this method
    public List<Product> getProducts(
            @RequestParam(required = false) String category, // Optional query parameter for filtering by product category
            @RequestParam(required = false) Double minPrice, // Optional query parameter for filtering by minimum price
            @RequestParam(required = false) Double maxPrice, // Optional query parameter for filtering by maximum price
            @RequestParam(required = false) Boolean inStock, // Optional query parameter for filtering by stock status
            @RequestParam(required = false) String sortField, // Optional query parameter for specifying sorting field
            @RequestParam(required = false) String sortOrder) { // Optional query parameter for specifying sorting order
        // Calls the ProductService to get the list of products based on the provided parameters
        return productService.getProducts(category, minPrice, maxPrice, inStock, sortField, sortOrder);
    }
}
