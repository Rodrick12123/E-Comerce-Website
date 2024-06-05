package com.example.CogentCapstone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	public Product save(Product product) {
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
