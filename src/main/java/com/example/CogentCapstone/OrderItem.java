package com.example.CogentCapstone;


import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private CustomerOrder order;

    @ManyToOne
    private Product product;

    private Integer quantity;
    private Double price;
    private String name;
    private String img;
    
    public void setImg(String img) {
    	this.img = img;
    }
    public String getImg() {
    	return this.img;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public String getName() {
    	return this.name;
    }
	public void setOrder(CustomerOrder order2) {
		this.order = order2;	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void setQuantity(int q) {
		this.quantity = q;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getPrice() {
		return this.price;
	}

}

