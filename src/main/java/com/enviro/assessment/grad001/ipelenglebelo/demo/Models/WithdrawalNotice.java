package com.enviro.assessment.grad001.ipelenglebelo.demo.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class WithdrawalNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    private LocalDate startDate; // New field
    private LocalDate endDate;

    // Add the relationship to Investor
    // Many-to-One relationship with Investor
    @ManyToOne
    @JoinColumn(name = "investor_id") // Name of the foreign key column in the withdrawal_notice table
    private Investor investor;


    // Many-to-One relationship with Product
    @ManyToOne
    @JoinColumn(name = "product_id") // Name of the foreign key column in the withdrawal_notice table
    private Product product;

    @Column(name = "withdrawal_amount")
    private double withdrawalAmount;

    @Column(name = "created_date") // Add a field for the created date
    private LocalDateTime createdDate;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // Add getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(double withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
