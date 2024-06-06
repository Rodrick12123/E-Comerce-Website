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
    private WishlistService wishListService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<WishList>> getWishList(@PathVariable Long userId) {
        List<WishList> wishList = wishListService.getWishListByUserId(userId);
        return ResponseEntity.ok(wishList);
    }

    @PostMapping("/add")
    public ResponseEntity<WishList> addProductToWishList(@RequestParam Long userId, @RequestParam Long productId) {
        WishList wishList = wishListService.addProductToWishList(userId, productId);
        return ResponseEntity.ok(wishList);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> removeProductFromWishList(@RequestParam Long userId, @RequestParam Long productId) {
        wishListService.removeProductFromWishList(userId, productId);
        return ResponseEntity.noContent().build();
    }
}
