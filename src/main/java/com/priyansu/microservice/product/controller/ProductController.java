package com.priyansu.microservice.product.controller;

import com.priyansu.microservice.product.dto.ProductRequestDto;
import com.priyansu.microservice.product.dto.ProductResponseDto;
import com.priyansu.microservice.product.model.Product;
import com.priyansu.microservice.product.service.ProductServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Priyansu Sahoo
 * 28-04-2024
 * @Project product-service
 */

@RestController
@RequestMapping("/product")
@CrossOrigin
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImp productServiceImp;

    @PostMapping("/createProduct")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductRequestDto productRequestDto){
        return productServiceImp.createProduct(productRequestDto);
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<ProductResponseDto>> getAllProduct(){
        return productServiceImp.getAllProduct();
    }
}
