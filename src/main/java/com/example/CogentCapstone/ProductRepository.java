package com.example.CogentCapstone;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
	List<Product> findByCategory(String category);
	List<Product> findAll(Sort sort);
}
