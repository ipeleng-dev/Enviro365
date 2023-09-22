package com.enviro.assessment.grad001.ipelenglebelo.demo.Service;

import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Investor;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Product;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.WithdrawalNotice;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Repository.ProductRepository;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Repository.withdrawalNoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;


    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductsByInvestorId(Long investorId) {
        try {
            return productRepository.findByInvestorId(investorId);
        } catch (Exception e) {
            // Handle the exception or log it
            throw new RuntimeException("Failed to retrieve products for investor with ID: " + investorId, e);
        }
    }

    // Other methods for updating or creating products
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

   
}