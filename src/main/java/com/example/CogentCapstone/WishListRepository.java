package com.example.CogentCapstone;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList, Long> {
    List<WishList> findByUser(User user);

	WishList findByUserId(Long userId);

	WishList findByUserAndProduct(User user, Product product);
}
