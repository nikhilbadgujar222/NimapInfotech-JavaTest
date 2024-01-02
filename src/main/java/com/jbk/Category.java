package com.jbk;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Component
@Entity
@Table
public class Category {
	
	@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int categoryId;
	public String categoryName;
	public String categoryDescp;
	
	//Category<>
	
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @JsonManagedReference
    public List<Product> products = new ArrayList();

    public Category() {
    }

	public Category(int categoryId, String categoryName, String categoryDescp) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescp = categoryDescp;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescp() {
		return categoryDescp;
	}

	public void setCategoryDescp(String categoryDescp) {
		this.categoryDescp = categoryDescp;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescp="
				+ categoryDescp + "]";
	}


    
    
	
    
    
    
}
