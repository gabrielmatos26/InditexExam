package com.inditex.exam.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.inditex.exam.model.Price;
import com.inditex.exam.repository.PriceRepository;

@Service
public class PriceService {
	@Autowired
	PriceRepository  priceRepository;
	
	public Price createPrice(Price price) {
	    return priceRepository.save(price);
	}

	public List<Price> getPrices() {
	    return priceRepository.findAll();
	}
	
	public Price getPriceByProduct(Long productId) {
		List<Price> prices = new ArrayList<Price>(priceRepository.findPriceByProduct(productId, Sort.by(Sort.Direction.DESC, "priority")));
		if(prices.size() > 0) {
			return prices.get(0);
		}
		return null;
	}
	
	public Price getPriceByProductAndBrand(Long productId, Integer brandId) {
		if(brandId == null) {
			return getPriceByProduct(productId);
		}
		
		List<Price> prices = new ArrayList<Price>(priceRepository.findPriceByProductAndBrand(productId, brandId, 
				Sort.by(Sort.Direction.DESC, "priority")));
		if(prices.size() > 0) {
			return prices.get(0);
		}
		return null;
	}

	public Price getPriceByProductAndDate(Long productId, LocalDateTime date) {
		if(date == null) {
			return getPriceByProduct(productId);
		}
		
		List<Price> prices = new ArrayList<Price>(priceRepository.findPriceByProductAndDate(productId, date,
				Sort.by(Sort.Direction.DESC, "priority")));
		if(prices.size() > 0) {
			return prices.get(0);
		}
		return null;
	}

	public Price getPriceByProductAndBrandAndDate(Long productId, Integer brandId, LocalDateTime date) {
		if(date == null) {
			return getPriceByProductAndBrand(productId, brandId);
		}else if(brandId == null) {
			return getPriceByProductAndDate(productId, date);
		}
		
		List<Price> prices = new ArrayList<Price>(priceRepository.findPriceByProductAndBrandAndDate(productId, brandId, date,
				Sort.by(Sort.Direction.DESC, new String[] {"priority", "priceList"})));
		if(prices.size() > 0) {
			return prices.get(0);
		}
		return null;
	}
	
	public void deletePrice(Long priceList) {
		priceRepository.deleteById(priceList);
	}
	
	public Price updatePrice(Long priceList, Price priceDetails) {
        Price price = priceRepository.findById(priceList).get();
        
        price.setCurr(priceDetails.getCurr());
        price.setEndDate(priceDetails.getEndDate());
        price.setStartDate(priceDetails.getStartDate());
        price.setProductId(priceDetails.getProductId());
        price.setPriority(priceDetails.getPriority());
        price.setPrice(priceDetails.getPrice());
        
        return priceRepository.save(price);                                
}

}
