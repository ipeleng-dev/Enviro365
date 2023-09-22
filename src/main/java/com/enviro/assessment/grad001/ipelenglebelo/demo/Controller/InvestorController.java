package com.enviro.assessment.grad001.ipelenglebelo.demo.Controller;

import com.enviro.assessment.grad001.ipelenglebelo.demo.DataTranfereObject.InvestorDto;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Investor;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Repository.InvestorRepository;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Repository.ProductRepository;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Services.InvestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/investors")
public class InvestorController {

    @Autowired
    private InvestorRepository investorRepository;

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private InvestorService investorService;

    @PostMapping("/create")
    public ResponseEntity<InvestorDto> createInvestor(@RequestBody InvestorDto investorDto) {
        // Convert InvestorDto to Investor entity
        Investor investor = new Investor();
        investor.setId(investorDto.getId());
        investor.setName(investorDto.getName());
        investor.setLastName(investorDto.getLastName());
        investor.setDateOfBirth(investorDto.getDateOfBirth());
        investor.setAddress(investorDto.getAddress());
        investor.setStreet(investorDto.getStreet());

        // Save the investor to the database
        Investor savedInvestor = investorService.saveInvestor(investor);

        // Convert the saved Investor back to InvestorDto for the response
        InvestorDto savedInvestorDto = new InvestorDto();
        savedInvestorDto.setId(investor.getId());
        savedInvestorDto.setName(savedInvestor.getName());
        savedInvestorDto.setLastName(savedInvestor.getLastName());
        savedInvestorDto.setDateOfBirth(savedInvestor.getDateOfBirth());
        savedInvestorDto.setStreet(investor.getStreet());
        savedInvestorDto.setAddress(investor.getAddress());

        return new ResponseEntity<>(savedInvestorDto, HttpStatus.CREATED);
    }

    // Endpoint to retrieve all investors
    @GetMapping("/all")
    public List<Investor> getAllInvestors() {
        return investorService.getAllInvestors();
    }

    @GetMapping("/{investorId}")
    public ResponseEntity<Investor> getInvestorById(@PathVariable Long investorId) {
        Investor investor = investorService.getInvestorById(investorId);

        if (investor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if the investor is not found
        }

        return new ResponseEntity<>(investor, HttpStatus.OK);
    }
}
