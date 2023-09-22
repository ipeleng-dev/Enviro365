package com.enviro.assessment.grad001.ipelenglebelo.demo.Repository;

import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByInvestorId(Long investorId);
}
