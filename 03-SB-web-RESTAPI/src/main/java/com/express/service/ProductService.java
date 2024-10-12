package com.express.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.express.entities.Product;
import com.express.repository.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository productRepository;
	
	public void createProduct(Product product) {
		product.setIsStock(true);
		product.setBarCode(UUID.randomUUID().toString());
		productRepository.save(product);
	}
	public Product fetchProductInfo(long productId) {
		return productRepository.findById(productId)
				.orElseThrow(() -> new RuntimeException("Product Not Found"));
	}
	public List<Product> fetchProducts(String name) {
		return productRepository.findByCategoryName(name);
	}
}

