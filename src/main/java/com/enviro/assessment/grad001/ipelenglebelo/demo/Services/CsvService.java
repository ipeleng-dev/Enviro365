package com.enviro.assessment.grad001.ipelenglebelo.demo.Services;

import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.WithdrawalNotice;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

@Service
public class CsvService {

    public byte[] generateCsv(List<WithdrawalNotice> withdrawalNotice) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new OutputStreamWriter(outputStream), CSVFormat.DEFAULT);

        // Write CSV header
        csvPrinter.printRecord("Withdrawal Request ID", "Investor Name", "Product Name", "Withdrawal Amount", "Created Date");

        // Write withdrawal requests as CSV rows
        for (WithdrawalNotice withdrawalRequest : withdrawalNotice) {
            csvPrinter.printRecord(
                    withdrawalRequest.getId(),
                    withdrawalRequest.getInvestor().getName(),
                    withdrawalRequest.getProduct().getName(),
                    withdrawalRequest.getWithdrawalAmount(),
                    withdrawalRequest.getCreatedDate()
            );
        }

        csvPrinter.flush();
        return outputStream.toByteArray();
    }
}
