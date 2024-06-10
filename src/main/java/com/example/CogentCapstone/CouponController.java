package com.example.CogentCapstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @PostMapping
    public Coupon createCoupon(@RequestBody CouponRequest couponRequest) {
        return couponService.createCoupon(
                couponRequest.getCode(),
                couponRequest.getDiscount(),
                couponRequest.getUserId()
        );
    }
    
    @GetMapping("/users")
    public List<Coupon> getCoupons() {
        return couponService.getCoupons();
    }

    @GetMapping("/user/{userId}")
    public List<Coupon> getCouponsByUser(@PathVariable Long userId) {
        return couponService.getCouponsByUser(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteCoupon(@PathVariable Long id) {
        couponService.deleteCoupon(id);
    }
}

class CouponRequest {
    private String code;
    private double discount;
    private Long userId;

    // Getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
