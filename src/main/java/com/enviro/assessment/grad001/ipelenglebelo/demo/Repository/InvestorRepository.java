package com.enviro.assessment.grad001.ipelenglebelo.demo.Repository;

import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {
    // You can add custom query methods here if needed
}