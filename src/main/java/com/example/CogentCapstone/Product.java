package com.example.CogentCapstone;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private int price;
	private int quantity;
	private String category;
	private String name;
	
	public Product(int price, int quantity, String category, String name) {
		this.price = price;
		this.quantity = quantity;
		this.name = name;
		this.category = category;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name= name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setCategory() {
		this.category = category;
	}
	
	public String getCategory() {
		return this.category;
	}
}
