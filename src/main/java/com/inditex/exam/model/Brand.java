package com.inditex.exam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "BRAND")
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NAME")
	private String name;
	
	@OneToMany(mappedBy = "brand", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Price> pricesList;
	
	public Brand() {

	}

	public Brand(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@JsonIgnore
	public List<Price> getPricesList() {
		if (this.pricesList == null) {
			return new ArrayList<Price>();
		}
		return pricesList;
	}

	public void setPricesList(List<Price> pricesList) {
		this.pricesList = pricesList;
	}

	public void addPricesList(Price price) {
		if (this.pricesList == null) {
			this.pricesList = new ArrayList<Price>();
		}
		this.pricesList.add(price);
	}
	
	public void removePricesList(Price price) {
		if (this.pricesList == null) {
			this.pricesList = new ArrayList<Price>();
		}
		if (this.pricesList.size() > 0) {
			this.pricesList.removeIf(x -> x.getPriceList().equals(price.getPriceList()));
		}
	}

	@Override
	public String toString() {
		return String.format("Brand [id=%d, name=%s]", this.id, this.name);
	}

}
