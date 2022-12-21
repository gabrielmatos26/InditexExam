package com.inditex.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inditex.exam.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
