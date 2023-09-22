package com.enviro.assessment.grad001.ipelenglebelo.demo.Services;

import com.enviro.assessment.grad001.ipelenglebelo.demo.DataTranfereObject.WithdrawalRequestDto;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Investor;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Product;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.WithdrawalNotice;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Repository.WithdrawalNoticeRepository;
import jakarta.annotation.Resource;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;

@Service
public class WithdrawalService {

    private final ProductService productService;

    @Autowired
    public WithdrawalService(ProductService productService) {
        this.productService = productService;
    }


    public String processWithdrawal(WithdrawalRequestDto withdrawalRequestDto) {
        // Retrieve the product by its ID
        Product product = productService.getProductById(withdrawalRequestDto.getProductId());

        if (product == null) {
            return "Product not found";
        }

        // Retrieve the investor associated with the product
        Investor investor = product.getInvestor();

        // Perform withdrawal validations
        double withdrawalAmount = withdrawalRequestDto.getWithdrawalAmount();
        double currentBalance = product.getCurrentBalance();

        // Check if WITHDRAWAL AMOUNT is greater than current BALANCE
        if (withdrawalAmount > currentBalance) {
            return "Insufficient balance";
        }

        // Check if PRODUCT is RETIREMENT and investor's age is greater than 65
        if ("RETIREMENT".equals(product.getType()) && investor != null) {
            int investorAge = investor.calculateAge(); // Use the calculateAge method
            if (investorAge <= 65) {
                return "Investor's age must be greater than 65 for RETIREMENT products";
            }
        }

        // Check if WITHDRAWAL AMOUNT is more than 90% of current BALANCE
        double ninetyPercentOfBalance = 0.9 * currentBalance;
        if (withdrawalAmount > ninetyPercentOfBalance) {
            return "Withdrawal amount exceeds 90% of the current balance";
        }

        // Update the product's balance and save it
        double newBalance = currentBalance - withdrawalAmount;
        product.setCurrentBalance(newBalance);
        productService.saveProduct(product);

        return "Success";
    }


    //generate csv statement

}


