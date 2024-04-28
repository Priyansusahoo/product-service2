package com.priyansu.microservice.product.service;

import com.priyansu.microservice.product.dto.ProductRequestDto;
import com.priyansu.microservice.product.dto.ProductResponseDto;
import com.priyansu.microservice.product.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Priyansu Sahoo
 * 28-04-2024
 * @Project product-service
 */
public interface ProductService {
    ResponseEntity<ProductResponseDto> createProduct(ProductRequestDto productRequestDto);

    ResponseEntity<List<ProductResponseDto>> getAllProduct();
}
