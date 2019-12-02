package com.onlinemusicstore.app.models;

public class PricesWithDiscount {
	
	private int id;
	private double basicPrice;
	private double discountPercentage;
	private double discountPrice;
	private double genericDiscount;
	private Product proId;
	
	
	public Product getProId() {
		return proId;
	}
	public void setProId(Product proId) {
		this.proId = proId;
	}
	public PricesWithDiscount(int id, double basicPrice, double discountPercentage, double discountPrice,
			double genericDiscount) {
		super();
		this.id = id;
		this.basicPrice = basicPrice;
		this.discountPercentage = discountPercentage;
		this.discountPrice = discountPrice;
		this.genericDiscount = genericDiscount;
	}
	public PricesWithDiscount() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBasicPrice() {
		return basicPrice;
	}
	public void setBasicPrice(double basicPrice) {
		this.basicPrice = basicPrice;
	}
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public double getGenericDiscount() {
		return genericDiscount;
	}
	public void setGenericDiscount(double genericDiscount) {
		this.genericDiscount = genericDiscount;
	}
	
	

}
