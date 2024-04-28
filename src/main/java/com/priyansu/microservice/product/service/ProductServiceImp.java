package com.priyansu.microservice.product.service;

import com.priyansu.microservice.product.dto.ProductRequestDto;
import com.priyansu.microservice.product.dto.ProductResponseDto;
import com.priyansu.microservice.product.model.Product;
import com.priyansu.microservice.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Priyansu Sahoo
 * 28-04-2024
 * @Project product-service
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<ProductResponseDto> createProduct(ProductRequestDto productRequestDto) {
        try {
            if (!productRequestDto.name().isEmpty()) {
                Product newProduct = Product.builder()
                        .name(productRequestDto.name())
                        .description(productRequestDto.description())
                        .price(productRequestDto.price())
                        .build();

                productRepository.save(newProduct);
                log.info("***************LOGGER*************** Product with id {} saved successfully", newProduct.getId());
                return ResponseEntity.ok().body(new ProductResponseDto(newProduct.getId(), newProduct.getName(), newProduct.getDescription(), newProduct.getPrice()));
            }
            log.error("Product name : {} is empty/null", productRequestDto.name());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            log.error("***************ERROR*************** unable to save product");
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<List<ProductResponseDto>> getAllProduct() {
        try {
            log.info("***************LOGGER*************** All product fetched successfully");
            return ResponseEntity.ok().body(productRepository
                    .findAll()
                    .stream()
                    .map(product -> new ProductResponseDto(product.getId(), product.getName(),product.getDescription(), product.getPrice())).toList());
        } catch (Exception e) {
            log.error("***************ERROR*************** Unable to fetch all Products");
            throw new RuntimeException(e);
        }
    }
}
