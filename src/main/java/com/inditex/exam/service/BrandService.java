package com.inditex.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.exam.model.Brand;
import com.inditex.exam.repository.BrandRepository;

@Service
public class BrandService {
	@Autowired
	BrandRepository  brandRepository;
	
	// CREATE 
	public Brand createBrand(Brand brand) {
	    return brandRepository.save(brand);
	}

	// READ
	public List<Brand> getBrands() {
	    return brandRepository.findAll();
	}

	// DELETE
	public void deleteBrand(int brandId) {
		brandRepository.deleteById(brandId);
	}
	
	

}
