package com.enviro.assessment.grad001.ipelenglebelo.demo.DataTranfereObject;

import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Investor;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDate;

public class WithdrawalRequestDto {
    private Long productId;
    private double withdrawalAmount;

    private LocalDate startDate; // New field
    private LocalDate endDate;

    private Investor investor;

    @ManyToOne
    @JoinColumn(name = "product_id") // Name of the foreign key column in the withdrawal_notice table
    private Product product;

    // Constructors, getters, and setters

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(double withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }
}
