package org.uniandes.proseg.group6.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Coupon {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Double price;
	private String couponCypher;
	
	
	
	public Coupon(String name, Double price, String couponCypher) {
		super();
		this.name = name;
		this.price = price;
		this.couponCypher = couponCypher;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Coupon() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCouponCypher() {
		return couponCypher;
	}

	public void setCouponCypher(String couponCypher) {
		this.couponCypher = couponCypher;
	}
	
	
	
}
