package com.example.CogentCapstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//ToDo:Finnish wishlist service
@Service
public class WishlistService {
    @Autowired
    private WishListRepository wishlistRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public WishList getWishlistByUserId(Long userId) {
        return wishlistRepository.findByUserId(userId);
    }

    public WishList addItemToWishlist(Long userId, Long productId) {
        WishList wishlist = getWishlistByUserId(userId);
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // Check if the product is already in the wishlist
        WishList existingWishlistItem = wishlistRepository.findByUserAndProduct(user, product);

        if (existingWishlistItem != null) {
            return wishlist; 
        } else {
            WishList newItem = new WishList();
            newItem.setUser(user);
            newItem.setProduct(product);
            return wishlistRepository.save(newItem);
        }
    }

    public void removeItemFromWishlist(Long userId, Long productId) {
        WishList wishlist = getWishlistByUserId(userId);
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        WishList item = wishlistRepository.findByUserAndProduct(wishlist.getUser(), product);
        wishlistRepository.delete(item);
    }
}
