package com.priyansu.microservice.product.repository;

import com.priyansu.microservice.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Priyansu Sahoo
 * 28-04-2024
 * @Project product-service
 */
public interface ProductRepository extends MongoRepository<Product, String> {
}
