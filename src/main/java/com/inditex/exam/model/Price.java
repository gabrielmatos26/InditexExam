package com.inditex.exam.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "PRICES")
public class Price {
	@Id
	@Column(name = "PRICE_LIST")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long priceList;

	@Column(name = "BRAND_ID", insertable = false, updatable = false)
	private int brandId;

	@Column(name = "START_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime startDate;

	@Column(name = "END_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime endDate;

	@Column(name = "PRODUCT_ID")
	private Long productId;

	@Column(name = "PRIORITY")
	private int priority;

	@Column(name = "PRICE")
	private BigDecimal price;

	@Column(name = "CURR")
	private String curr;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "BRAND_ID")
	private Brand brand;

	public Price() {

	}

	public Price(LocalDateTime startDate, LocalDateTime endDate, Long productId, int priority, BigDecimal price,
			String curr, Brand brand) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
		this.brand = brand;
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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
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

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

//	@Override
//	public String toString() {
//		return String.format("Brand [id=%d, name=%s]", this.id, this.name);
//	}

}
