package com.enviro.assessment.grad001.ipelenglebelo.demo.Controller;

import com.enviro.assessment.grad001.ipelenglebelo.demo.DataTranfereObject.WithdrawalRequestDto;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.WithdrawalNotice;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Repository.WithdrawalNoticeRepository;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Services.CsvService;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Services.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/api/withdrawals")
public class WithdrawalController {

    private final WithdrawalService withdrawalService;
    @Autowired
    private CsvService csvService;
    @Autowired
    private WithdrawalNoticeRepository repo;

    @Autowired
    public WithdrawalController(WithdrawalService withdrawalService) {
        this.withdrawalService = withdrawalService;
    }

    @PostMapping("/request")
    public ResponseEntity<String> requestWithdrawal(@RequestBody WithdrawalRequestDto withdrawalRequestDto) {
        // Call the withdrawal service to process the request
        String response = withdrawalService.processWithdrawal(withdrawalRequestDto);

        if (response.equals("Success")) {
            return new ResponseEntity<>("Withdrawal request successful.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Withdrawal request failed: " + response, HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/export/{id}")
    public ResponseEntity<byte[]> exportWithdrawalRequestsToCsv(@PathVariable Long id) throws IOException {
        // Retrieve withdrawal requests by ID (adjust this query according to your data model)
        List<WithdrawalNotice> withdrawalRequests = repo.findByInvestorId(id);

        // Generate CSV content
        byte[] csvContent = csvService.generateCsv(withdrawalRequests);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "withdrawal_requests.csv");

        return new ResponseEntity<>(csvContent, headers, HttpStatus.OK);
    }


}

