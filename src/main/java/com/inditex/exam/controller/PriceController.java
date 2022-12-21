package com.inditex.exam.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.exam.dto.PriceDTO;
import com.inditex.exam.exceptions.PriceNotFoundException;
import com.inditex.exam.model.Price;
import com.inditex.exam.service.PriceService;

@RestController
@RequestMapping("/api")
public class PriceController {
	
	@Autowired
	private PriceService priceService;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@RequestMapping(value="/prices", method=RequestMethod.POST)
	public Price createEmployee(@RequestBody Price price) {
	    return priceService.createPrice(price);
	}
	
	@RequestMapping(value="/prices", method=RequestMethod.GET)
	public List<Price> readPrices() {
	    return priceService.getPrices(); 
	}
	
	@RequestMapping(value="/prices/price", method=RequestMethod.GET)
	public PriceDTO readPrice(@RequestParam(value = "product") Long productId, 
			@RequestParam(value = "brand", required=false) Integer brandId, 
			@RequestParam(value = "date", required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
		
		Price price = priceService.getPriceByProductAndBrandAndDate(productId, brandId, date);
		if(price != null) {
			return modelMapper.map(price, PriceDTO.class);
		}
		if(brandId == null && date == null) {
			throw new PriceNotFoundException(Price.class, productId);
		}else if(brandId == null) {
			throw new PriceNotFoundException(Price.class, productId, date);
		}else if(date == null) {
			throw new PriceNotFoundException(Price.class, productId, brandId);
		}else {
			throw new PriceNotFoundException(Price.class, productId, brandId, date);
		}
	}

	@RequestMapping(value="/prices/{id}", method=RequestMethod.DELETE)
	public void deleteEmployees(@PathVariable(value = "id") Long id) {
		priceService.deletePrice(id);
	}
	
}
