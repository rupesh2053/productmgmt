package com.rupesh.app.service;

import com.rupesh.app.entities.Product;

public interface ProductService {
	public abstract void registerProduct(Product product);
	public abstract Iterable<Product> getAllProducts();
	public abstract Product getProductById(Integer productId);
	public abstract void deleteProduct(Integer productId);
}
