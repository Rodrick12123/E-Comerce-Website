package com.example.CogentCapstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {
    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<WishList> getWishListByUserId(Long userId) {
        return wishListRepository.findByUserId(userId);
    }

    @Transactional
    public WishList addProductToWishList(Long userId, Long productId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Optional<WishList> existingWishList = wishListRepository.findByUserAndProduct(user, product);

        if (existingWishList != null) {
            return existingWishList.get(); 
        } else {
            WishList newWishList = new WishList();
            newWishList.setUser(user);
            newWishList.setProduct(product);
            return wishListRepository.save(newWishList);
        }
    }

    @Transactional
    public void removeProductFromWishList(Long userId, Long productId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Optional<WishList> wishListOpt = wishListRepository.findByUserAndProduct(user, product);
        if (wishListOpt.isPresent()) {
        	WishList wishList = wishListOpt.get();
            wishListRepository.delete(wishList);;
        }
    }
}
