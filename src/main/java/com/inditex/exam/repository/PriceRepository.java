package com.inditex.exam.repository;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inditex.exam.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
	@Query("SELECT p FROM Price p WHERE p.productId = :productId")
	Collection<Price> findPriceByProduct(@Param("productId") Long productId, Sort sort);

	@Query("SELECT p FROM Price p WHERE p.productId = :productId and p.brandId = :brandId")
	Collection<Price> findPriceByProductAndBrand(@Param("productId") Long productId, @Param("brandId") Integer brandId, Sort sort);
	
	@Query("SELECT p FROM Price p WHERE p.productId = :productId and p.startDate <= :date and p.endDate >= :date")
	Collection<Price> findPriceByProductAndDate(@Param("productId") Long productId,
			@Param("date") LocalDateTime date, Sort sort);
	
	@Query("SELECT p FROM Price p WHERE p.productId = :productId and p.brandId = :brandId and p.startDate <= :date and p.endDate >= :date")
	Collection<Price> findPriceByProductAndBrandAndDate(@Param("productId") Long productId, @Param("brandId") Integer brandId, 
			@Param("date") LocalDateTime date, Sort sort);
	
}
