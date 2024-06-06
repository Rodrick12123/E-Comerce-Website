package com.example.CogentCapstone;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	private Random random = new Random();
	
	private Long generateRandomId() {
	    return random.nextLong(1, Long.MAX_VALUE); 
	}
	
	public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(generateRandomId());
        }
        return productRepo.save(product);
    }
	public List<Product> getAllProductsSorted(String sortBy){
		Sort sort = Sort.by(sortBy).ascending(); 
        return productRepo.findAll(sort);
		
	}
	public List<Product> loadProductByCategory(String category) {
		return productRepo.findByCategory( category);
	}
	
	public List<Product> getAllProducts(){
		
		return productRepo.findAll();
	}
	
	public void deleteById(Long id) {
        productRepo.deleteById(id);
    }
	
	public List<Product> findAllByOrderByPriceDesc() {
        return productRepo.findAllByOrderByPriceDesc();
    }
}
