package com.onlinemusicstore.app.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Le on 1/2/2016.
 */

@Entity
public class Product {

    @Id
    private String productId;

    @NotNull (message = "The product name must not be null.")
    private String productName;
    
    private String productCategory;
    
    private String productDescription;

	/*
	 * @Min(value = 0, message = "The product price must no be less then zero.")
	 * private double productPrice;
	 */
    private String productCondition;
    
    private String productStatus;

    @Min(value = 0, message = "The product unit must not be less than zero.")
    private int unitInStock;
    
    private String productManufacturer;

	/*
	 * @OneToOne(targetEntity =Price.class,mappedBy = "product") private Price
	 * price;
	 */
    
    @OneToMany(targetEntity =Price2.class,mappedBy = "product" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Price2> price2;
    
   
    


	public List<Price2> getPrice2() {
		return price2;
	}

	public void setPrice2(List<Price2> price2) {
		this.price2 = price2;
	}

	@Transient
    private MultipartFile productImage;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

	/*
	 * public double getProductPrice() { return productPrice; }
	 * 
	 * public void setProductPrice(double productPrice) { this.productPrice =
	 * productPrice; }
	 */
    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }
}
