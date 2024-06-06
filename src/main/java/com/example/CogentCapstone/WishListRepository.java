package com.example.CogentCapstone;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList, Long> {
	List<WishList> findByUserId(Long userId);
    Optional<WishList> findByUserAndProduct(User user, Product product);
}
