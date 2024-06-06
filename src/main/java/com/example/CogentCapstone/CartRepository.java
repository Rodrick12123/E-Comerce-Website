package com.example.CogentCapstone;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
	List<Cart> findByUserId(Long userId);
    Optional<Cart> findByUserAndProduct(User user, Product product);
    void deleteAllByUser(User user);

}