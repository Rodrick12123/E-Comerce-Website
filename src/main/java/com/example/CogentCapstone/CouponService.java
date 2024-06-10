package com.example.CogentCapstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {
    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private UserRepository userRepository;

    public Coupon createCoupon(String code, double discount, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Coupon coupon = new Coupon();
        coupon.setCode(code);
        coupon.setDiscount(discount);
        coupon.setUser(user);

        return couponRepository.save(coupon);
    }

    public List<Coupon> getCouponsByUser(Long userId) {
        return couponRepository.findByUserId(userId);
    }

    public void deleteCoupon(Long id) {
        couponRepository.deleteById(id);
    }

	public List<Coupon> getCoupons() {
		return couponRepository.findAll();
	}
}
