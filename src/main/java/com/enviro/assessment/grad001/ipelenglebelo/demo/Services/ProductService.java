package com.enviro.assessment.grad001.ipelenglebelo.demo.Services;

import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.AddProductsRequest;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Investor;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Product;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(Long id) {
        // Implement retrieval logic
        return productRepository.findById(id).orElse(null);
    }

    public void updateProduct(Long id, Product updatedProduct) {
        // Implement update logic, including validation
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            // Update existingProduct with the data from updatedProduct
            existingProduct.setType(updatedProduct.getType());
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setCurrentBalance(updatedProduct.getCurrentBalance());
            productRepository.save(existingProduct);
        }
    }

    public void deleteProduct(Long id) {
        // Implement deletion logic
        productRepository.deleteById(id);
    }

    // Implement other product-related business logic as needed
    public List<Product> getProductsByIds(List<Long> productIds) {
        // Use Spring Data JPA to retrieve products by their IDs
        return productRepository.findAllById(productIds);
    }

    public void addProductsToInvestor(Investor investor, List<AddProductsRequest.ProductRequest> productRequests) {
        // Iterate over the list of product requests and create Product entities
        for (AddProductsRequest.ProductRequest productRequest : productRequests) {
            Product product = new Product();
            product.setName(productRequest.getName());
            product.setType(productRequest.getType());
            product.setCurrentBalance(productRequest.getCurrentBalance());

            // Associate the product with the investor
            product.setInvestor(investor);

            // Save the product in the database
            productRepository.save(product);
        }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> addProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}

