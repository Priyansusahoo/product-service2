package com.priyansu.microservice.product.dto;

import java.math.BigDecimal;

/**
 * @author Priyansu Sahoo
 * 28-04-2024
 * @Project product-service
 */
public record ProductResponseDto(String id, String name, String description, BigDecimal price) {};
