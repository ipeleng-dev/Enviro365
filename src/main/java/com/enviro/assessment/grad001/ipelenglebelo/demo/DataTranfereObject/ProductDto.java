package com.enviro.assessment.grad001.ipelenglebelo.demo.DataTranfereObject;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class ProductDto {
    private String name;
    private String type;
    private double currentBalance;

    private Date startDate;

    private Date endDate;

    private Long investorId;

    private String investorFirstName;
    private String investorLastName;

    private LocalDate dateOfBirth;

    // Constructors, getters, and setters

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public String getInvestorFirstName() {
        return investorFirstName;
    }

    public void setInvestorFirstName(String investorFirstName) {
        this.investorFirstName = investorFirstName;
    }

    public String getInvestorLastName() {
        return investorLastName;
    }

    public void setInvestorLastName(String investorLastName) {
        this.investorLastName = investorLastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}