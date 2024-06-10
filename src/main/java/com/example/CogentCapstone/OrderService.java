package com.example.CogentCapstone;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public CustomerOrder createOrder(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Cart> cart = cartRepository.findByUserId(userId);
        List<Cart> cartItems = cartRepository.findByUser(user);

        CustomerOrder order = new CustomerOrder();
        order.setUser(user);
        order.setStatus("Pending");

        double totalAmount = 0.0;
        for (Cart cartItem : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setName(cartItem.getProduct().getName());
            orderItem.setImg(cartItem.getProduct().getImage());
            orderItem.setPrice(cartItem.getProduct().getPrice() * cartItem.getQuantity());
            
            totalAmount += orderItem.getPrice();
            order.getOrderItems().add(orderItem);
//            orderRepository.save(orderItem);
        }

        order.setTotalAmount(totalAmount);
        String date = LocalDateTime.now().toString();
        order.setDate(date);
        orderRepository.save(order);

        cartRepository.deleteAllByUser(user);

        return order;
    }
    public List<CustomerOrder> getAllOrders() {
        return orderRepository.findAll();
    }
}

