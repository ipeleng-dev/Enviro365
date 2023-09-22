package com.enviro.assessment.grad001.ipelenglebelo.demo.Repository;

import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Product;
import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.WithdrawalNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface WithdrawalNoticeRepository extends JpaRepository<WithdrawalNotice, Long> {
    List<WithdrawalNotice> findByInvestorId(Long investorId);
}
