package com.example.CogentCapstone;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;


@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private String name;
    private String category;
    private Double price;
    private Integer quantity;
    private String description;
    
   
	private String image;
    
	public Double getPrice() {
		return this.price;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	public void setQuantity(int q) {
		this.quantity = q;
	}
	public String getImage() {
		return this.image;
	}
	public void setImage(String image) {
		this.image= image;
	}
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id= id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name= name;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public String getDescription() {
		return this.description;
	}
}
