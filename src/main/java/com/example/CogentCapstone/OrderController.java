package com.example.CogentCapstone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public CustomerOrder createOrder(@RequestParam Long userId) {
        return orderService.createOrder(userId);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<CustomerOrder>> getAllOrders() {
        List<CustomerOrder> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
}
