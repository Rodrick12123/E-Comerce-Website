package com.example.CogentCapstone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//ToDo: Finish cart service
@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public Cart addItemToCart(Long userId, Long productId, int quantity) {
        Cart cart = getCartByUserId(userId);
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        // Check if the product is already in the cart
        Cart existingCartItem = cartRepository.findByUserAndProduct(user, product);

        if (existingCartItem != null) {
            Cart item = existingCartItem;
            item.setQuantity(item.getQuantity() + quantity);
            return cartRepository.save(item);
        } else {
            Cart newItem = new Cart();
            newItem.setUser(user);
            newItem.setProduct(product);
            newItem.setQuantity(quantity);
            return cartRepository.save(newItem);
        }
    }

    public Cart updateCartItem(Long userId, Long productId, int quantity) {
        Cart cart = getCartByUserId(userId);
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        Cart item = cartRepository.findByUserAndProduct(cart.getUser(), product);

        item.setQuantity(quantity);
        return cartRepository.save(item);
    }

    public void removeItemFromCart(Long userId, Long productId) {
        Cart cart = getCartByUserId(userId);
        Optional<Product> product = productRepository.findById(productId);

        Cart item = cartRepository.findByUserAndProduct(cart.getUser(), product);

        cartRepository.delete(item);
    }

    public void clearCart(Long userId) {
        Cart cart = getCartByUserId(userId);
        cartRepository.deleteAllByUser(cart.getUser());
    }
}

