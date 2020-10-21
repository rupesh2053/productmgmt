package com.rupesh.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.rupesh.app.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
