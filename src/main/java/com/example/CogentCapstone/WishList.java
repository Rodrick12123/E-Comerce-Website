package com.example.CogentCapstone;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class WishList {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Product product;
    
    public User getUser() {
    	return this.user;
    }
    
    public void setUser(User user) {
    	this.user = user;
    }
    
    public Product getProduct() {
    	return this.product;
    }
    
    public void setProduct(Product prod) {
    	this.product = prod;
    }
}
