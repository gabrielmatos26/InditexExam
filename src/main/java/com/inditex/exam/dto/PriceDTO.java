package com.inditex.exam.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PriceDTO {
	private Long priceList;

	private Integer brandId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime startDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime endDate;

	private Long productId;
	
	private BigDecimal price;
	
	private String curr;
	
	public PriceDTO() {
		
	}

	public PriceDTO(Long priceList, int brandId, LocalDateTime startDate, LocalDateTime endDate, Long productId,
			BigDecimal price, String curr) {
		super();
		this.priceList = priceList;
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.productId = productId;
		this.price = price;
		this.curr = curr;
	}

	public Long getPriceList() {
		return priceList;
	}

	public void setPriceList(Long priceList) {
		this.priceList = priceList;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		PriceDTO priceObj = (PriceDTO) obj;
		if(!this.priceList.equals(priceObj.priceList)) {
			return false;
		}
		if(this.brandId != priceObj.brandId) {
			return false;
		}
		if(!this.startDate.isEqual(priceObj.startDate)) {
			return false;
		}
		if(!this.endDate.isEqual(priceObj.endDate)) {
			return false;
		}
		if(!this.productId.equals(priceObj.productId)) {
			return false;
		}
		if(this.price.compareTo(priceObj.price) != 0) {
			return false;
		}
		if(!this.curr.equals(priceObj.curr)) {
			return false;
		}
		return true;
	}
	

}
