package com.jbk;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Component
@Table
@Entity
public class Product {

	
	@Id
	public int productId;
	public String productName;
	
	public String productQty;
	public String manafacturer;
	
	@ManyToOne
	@JsonBackReference
	public Category category;
	
	public Product() {
		
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, String productName, String productQty, String manafacturer) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productQty = productQty;
		this.manafacturer = manafacturer;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductQty() {
		return productQty;
	}
	public void setProductQty(String productQty) {
		this.productQty = productQty;
	}
	public String getManafacturer() {
		return manafacturer;
	}
	public void setManafacturer(String manafacturer) {
		this.manafacturer = manafacturer;
	}
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productQty=" + productQty
				+ ", manafacturer=" + manafacturer + "]";
	}
	
	
	
    
	
}
