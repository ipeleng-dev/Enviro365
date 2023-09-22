package com.enviro.assessment.grad001.ipelenglebelo.demo.Models;

import java.math.BigDecimal;
import java.util.List;

public class AddProductsRequest {
    private Long investorId;
    private List<ProductRequest> products;

    // Constructors, getters, and setters

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public List<ProductRequest> getProducts() {
        return products;
    }

    public void setProducts(List<ProductRequest> products) {
        this.products = products;
    }

    public static class ProductRequest {
        private String name;
        private String type;
        private double currentBalance;

        // Constructors, getters, and setters for ProductRequest

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getCurrentBalance() {
            return currentBalance;
        }

        public void setCurrentBalance(double currentBalance) {
            this.currentBalance = currentBalance;
        }
    }
}
