package com.enviro.assessment.grad001.ipelenglebelo.demo.Controller;

import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Investor;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Product;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Service.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investors")
public class InvestorController {
    private final InvestorService investorService;

    @Autowired
    public InvestorController(InvestorService investorService) {
        this.investorService = investorService;
    }

    @PostMapping
    public ResponseEntity<Investor> addInvestor(@RequestBody Investor investor) {
        try {
            // Create a new Product entity from the ProductDTO
            investor.setName(investor.getName());
            investor.setAddress(investor.getAddress());
            investor.setContact(investor.getContact());
            investor.setProducts(investor.getProducts());

            // Save the product to the database
            Investor savedInvestor = investorService.addInvestor(investor);

            // Return a response with the created product and HTTP status code 201 (Created)
            return ResponseEntity.status(HttpStatus.CREATED).body(savedInvestor);
        } catch (Exception e) {
            // Handle exceptions here, you can log the error or return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public List<Investor> getAllInvestors() {
        return investorService.getAllInvestors();
    }

    @GetMapping("/{id}")
    public Investor getInvestorById(@PathVariable Long id) {
        return investorService.getInvestorById(id);
    }
}