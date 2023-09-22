package com.enviro.assessment.grad001.ipelenglebelo.demo.Services;

import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Investor;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestorService {

    @Autowired
    private InvestorRepository investorRepository;

    @Autowired
    public InvestorService(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    // Create a new investor
    public Investor createInvestor(Investor investor) {
        // Implement any validation logic if needed
        return investorRepository.save(investor);
    }

    public Investor saveInvestor(Investor investor) {
        // Add any additional business logic or validation here if needed
        // For example, you can perform age validation, email validation, etc.

        // Save the investor to the database
        return investorRepository.save(investor);
    }

    // Retrieve an investor by ID
    public Investor getInvestorById(Long investorId) {
        return investorRepository.findById(investorId).orElse(null);
    }

    // Retrieve all investors
    public List<Investor> getAllInvestors() {
        return investorRepository.findAll();
    }


    // Delete an investor by ID
    public void deleteInvestorById(Long id) {
        investorRepository.deleteById(id);
    }
}


