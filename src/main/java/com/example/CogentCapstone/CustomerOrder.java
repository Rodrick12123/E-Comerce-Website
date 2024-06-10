package com.example.CogentCapstone;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderItem> orderItems;

    private String status;
    private Double totalAmount;
    private String date;
    
    public String getDate() {
    	return this.date;
    }
    public void setDate(String date) {
    	this.date = date;
    }
    
    public CustomerOrder() {
        this.orderItems = new ArrayList<>(); 
    }
    
    public List<OrderItem> getOrderItems(){
    	return this.orderItems;
    }
    
    public void setUser(User user) {
    	this.user = user;
    }
    
    public void setOrderItems(List<OrderItem> items) {
    	this.orderItems = items;
    }
    
    public void setStatus(String stat) {
    	this.status = stat;
    }
    public void setTotalAmount(Double i) {
    	this.totalAmount = i;
    }
    public Double getTotalAmount() {
    	return this.totalAmount;
    }
    
}


