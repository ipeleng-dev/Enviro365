package com.enviro.assessment.grad001.ipelenglebelo.demo.Controller;

import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Product;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        try {
            // Create a new Product entity from the ProductDTO
            product.setType(product.getType());
            product.setName(product.getName());
            product.setCurrentBalance(product.getCurrentBalance());

            // Save the product to the database
            Product savedProduct = productService.addProduct(product);

            // Return a response with the created product and HTTP status code 201 (Created)
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
        } catch (Exception e) {
            // Handle exceptions here, you can log the error or return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/investor/{investorId}")
    public List<Product> getProductsByInvestorId(@PathVariable Long investorId) {
        return productService.getProductsByInvestorId(investorId);
    }
}