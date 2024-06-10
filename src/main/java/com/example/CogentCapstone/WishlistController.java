package com.example.CogentCapstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
@CrossOrigin(origins = "http://localhost:4201")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/add")
    public ResponseEntity<WishList> addProductToWishList(@RequestParam Long userId, @RequestParam Long productId) {
        WishList wishList = wishlistService.addProductToWishList(userId, productId);
        return ResponseEntity.ok(wishList);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> removeProductFromWishList(@RequestParam Long userId, @RequestParam Long productId) {
        wishlistService.removeProductFromWishList(userId, productId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<WishList>> getWishList(@PathVariable Long userId) {
        List<WishList> wishList = wishlistService.getWishListByUserId(userId);
        return ResponseEntity.ok(wishList);
    }
}
