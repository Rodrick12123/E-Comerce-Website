package com.example.CogentCapstone;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;


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
    @Lob
	private byte[] image;
    
	public Double getPrice() {
		return this.price;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	public byte[] getImage() {
		return this.image;
	}
	public void setImage(byte[] image) {
		this.image= image;
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
	
	public void setCategory() {
		this.category = category;
	}
	
	public String getCategory() {
		return this.category;
	}
}
