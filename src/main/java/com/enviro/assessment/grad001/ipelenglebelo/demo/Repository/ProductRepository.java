package com.enviro.assessment.grad001.ipelenglebelo.demo.Repository;

import com.enviro.assessment.grad001.ipelenglebelo.demo.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);

    List<Product> findByType(String type);
}