package com.inditex.exam.exceptions;

import java.time.LocalDateTime;

public class PriceNotFoundException extends RuntimeException {

	public PriceNotFoundException(Class entityClass, Long productId) {
		super(String.format("Resource %s with product id %d not found", entityClass.getSimpleName(), productId));
	}

	public PriceNotFoundException(Class entityClass, Long productId, Integer brandId) {
		super(String.format("Resource %s with product id %d and brand id %d not found", entityClass.getSimpleName(), productId, brandId));
	}
	
	public PriceNotFoundException(Class entityClass, Long productId, LocalDateTime date) {
		super(String.format("Resource %s with product id %d and date %s not found",
				entityClass.getSimpleName(), productId, date.toString()));
	}
	
	public PriceNotFoundException(Class entityClass, Long productId, Integer brandId, LocalDateTime date) {
		super(String.format("Resource %s with product id %d, brand id %d and date %s not found",
				entityClass.getSimpleName(), productId, brandId, date.toString()));
	}
}
