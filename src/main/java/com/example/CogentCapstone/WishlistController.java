package com.example.CogentCapstone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wishlist")
@CrossOrigin(origins = "http://localhost:4201")
public class WishlistController {
    @Autowired
    private WishlistService wishlistService;

    @GetMapping("/{userId}")
    public ResponseEntity<WishList> getWishlist(@PathVariable Long userId) {
        WishList wishlist = wishlistService.getWishlistByUserId(userId);
        return ResponseEntity.ok(wishlist);
    }

    @PostMapping("/add")
    public ResponseEntity<WishList> addItemToWishlist(@RequestParam Long userId, @RequestParam Long productId) {
        WishList wishlist = wishlistService.addItemToWishlist(userId, productId);
        return ResponseEntity.ok(wishlist);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<Void> removeItemFromWishlist(@RequestParam Long userId, @RequestParam Long productId) {
        wishlistService.removeItemFromWishlist(userId, productId);
        return ResponseEntity.noContent().build();
    }
}