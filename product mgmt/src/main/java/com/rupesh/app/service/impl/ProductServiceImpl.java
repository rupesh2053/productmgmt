package com.rupesh.app.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rupesh.app.entities.Product;
import com.rupesh.app.repository.ProductRepository;
import com.rupesh.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void registerProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public Iterable<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer productId) {
		Product product = null;
		Optional<Product> productOptional = productRepository.findById(productId);
		if (productOptional.isPresent()) {
			product = productOptional.get();
		}
		return product;
	}

	@Override
	public void deleteProduct(Integer productId) {
		productRepository.deleteById(productId);
	}

}
