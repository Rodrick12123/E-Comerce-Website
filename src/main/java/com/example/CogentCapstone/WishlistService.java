package com.example.CogentCapstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class WishlistService {
    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    private static final Logger logger = Logger.getLogger(WishlistService.class.getName());

    public List<WishList> getWishListByUserId(Long userId) {
        return wishListRepository.findByUserId(userId);
    }

    @Transactional
    public WishList addProductToWishList(Long userId, Long productId) {
        logger.info("Adding product to wishlist: userId=" + userId + ", productId=" + productId);
        
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Optional<WishList> existingWishList = wishListRepository.findByUserAndProduct(user, product);

        if (existingWishList.isPresent()) {
            return existingWishList.get(); // Product is already in wishlist
        } else {
            WishList newWishList = new WishList();
            newWishList.setUser(user);
            newWishList.setProduct(product);
            return wishListRepository.save(newWishList);
        }
    }

    @Transactional
    public void removeProductFromWishList(Long userId, Long productId) {
        logger.info("Removing product from wishlist: userId=" + userId + ", productId=" + productId);
        
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Optional<WishList> wishListOptional = wishListRepository.findByUserAndProduct(user, product);
        if (wishListOptional.isPresent()) {
            WishList wishList = wishListOptional.get();
            wishListRepository.delete(wishList);
        } else {
            // Handle case when wish list entry does not exist
            logger.warning("WishList entry not found: userId=" + userId + ", productId=" + productId);
        }
    }
}
