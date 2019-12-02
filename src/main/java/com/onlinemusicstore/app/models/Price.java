//package com.onlinemusicstore.app.models;
//
//import java.io.Serializable;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//import javax.validation.constraints.Min;
//
//@Entity
//public class Price implements Serializable {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer id;
//	
//	@Min(value = 0, message = "The product price must no be less then zero.")
//	private double orignalPrice;
//	
//	@Min(value = 0, message = "The product price must no be less then zero.")
//	private double discountPrice;
//	
//	@Min(value = 0, message = "The product price must no be less then zero.")
//	private double genericDiscountPrice;
//	
//	private double percentageDiscount;
//	
//	private double genericDiscount;
//	
//	
//	
//	public double getGenericDiscount() {
//		return genericDiscount;
//	}
//
//
//
//	public void setGenericDiscount(double genericDiscount) {
//		this.genericDiscount = genericDiscount;
//	}
//
//	@OneToOne
//	@JoinColumn(name = "product_id")
//	private Product product;
//
//	
//	
//	public Price(Integer id, double orignalPrice, double discountPrice, double genericDiscountPrice, int percentageDiscount,
//			Product product) {
//		super();
//		this.id = id;
//		this.orignalPrice = orignalPrice;
//		this.discountPrice = discountPrice;
//		this.genericDiscountPrice = genericDiscountPrice;
//		this.percentageDiscount = percentageDiscount;
//		this.product = product;
//	}
//	
//	
//
//	public Price() {
//		super();
//	}
//
//
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public double getOrignalPrice() {
//		return orignalPrice;
//	}
//
//	public void setOrignalPrice(double orignalPrice) {
//		this.orignalPrice = orignalPrice;
//	}
//
//	public double getDiscountPrice() {
//		return discountPrice;
//	}
//
//	public void setDiscountPrice(double discountPrice) {
//		this.discountPrice = discountPrice;
//	}
//
//	public double getGenericDiscountPrice() {
//		return genericDiscountPrice;
//	}
//
//	public void setGenericDiscountPrice(double genericDiscountPrice) {
//		this.genericDiscountPrice = genericDiscountPrice;
//	}
//
//	public double getPercentageDiscount() {
//		return percentageDiscount;
//	}
//
//	public void setPercentageDiscount(double percentageDiscount) {
//		this.percentageDiscount = percentageDiscount;
//	}
//
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//
//	
//	
//	
//}
