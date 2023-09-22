package com.enviro.assessment.grad001.ipelenglebelo.demo.Service;

import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Investor;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Product;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestorService {
    private final InvestorRepository investorRepository;

    @Autowired
    public InvestorService(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    public List<Investor> getAllInvestors() {
        try {
            return investorRepository.findAll();
        } catch (Exception e) {
            // Handle the exception or log it
            throw new RuntimeException("Failed to retrieve investors", e);
        }
    }

    public Investor getInvestorById(Long id) {
        try {
            Optional<Investor> optionalInvestor = investorRepository.findById(id);
            if (optionalInvestor.isPresent()) {
                return optionalInvestor.get();
            } else {
                return null;
            }
        } catch (Exception e) {
            // Handle the exception or log it
            throw new RuntimeException("Failed to retrieve investor with id: " + id, e);
        }
    }

    // Other methods for updating or creating investors
    public Investor addInvestor(Investor investor) {
        return investorRepository.save(investor);
    }
}
