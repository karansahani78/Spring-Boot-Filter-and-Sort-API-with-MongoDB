package com.karan.productapi.Test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import com.karan.productapi.Model.Product;
import com.karan.productapi.Service.ProductService;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    // Test to verify fetching products by category
    @Test
    public void testGetProductsByCategory() {
        List<Product> products = productService.getProducts("electronics", null, null, null, null, null);
        assertNotNull(products); // Ensure the result is not null
        assertEquals(2, products.size()); // Verify the number of products returned
    }

    // Test to verify fetching products within a specific price range
    @Test
    public void testGetProductsByPriceRange() {
        List<Product> products = productService.getProducts(null, 100.0, 1000.0, null, null, null);
        assertNotNull(products); // Ensure the result is not null
        assertEquals(2, products.size()); // Verify the number of products returned
    }

    // Test to verify fetching products that are in stock
    @Test
    public void testGetProductsByInStock() {
        List<Product> products = productService.getProducts(null, null, null, true, null, null);
        assertNotNull(products); // Ensure the result is not null
        assertEquals(2, products.size()); // Verify the number of products returned
    }

    // Test to verify fetching products sorted by price in ascending order
    @Test
    public void testGetProductsSortedByPriceAsc() {
        List<Product> products = productService.getProducts(null, null, null, null, "price", "asc");
        assertNotNull(products); // Ensure the result is not null
        assertEquals(3, products.size()); // Verify the number of products returned
        assertEquals(299.99, products.get(0).getPrice()); // Verify the first product's price
    }

    // Test to verify fetching products sorted by rating in descending order
    @Test
    public void testGetProductsSortedByRatingDesc() {
        List<Product> products = productService.getProducts(null, null, null, null, "rating", "desc");
        assertNotNull(products); // Ensure the result is not null
        assertEquals(3, products.size()); // Verify the number of products returned
        assertEquals(4.7, products.get(0).getRating()); // Verify the first product's rating
    }
}
