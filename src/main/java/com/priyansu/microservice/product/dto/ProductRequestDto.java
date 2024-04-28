package com.priyansu.microservice.product.dto;


import java.math.BigDecimal;

public record ProductRequestDto(String id, String name, String description, BigDecimal price) {
}
