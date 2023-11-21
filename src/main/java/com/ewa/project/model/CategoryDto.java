package com.ewa.project.model;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.ewa.project.entity.Product;

public class CategoryDto {

	private Long categoryId;

	@NotBlank
	private String categoryName;

	private List<Product> products;

	// getter and setter
	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
