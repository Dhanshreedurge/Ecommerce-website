package com.ewa.project.model;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.ewa.project.entity.Cart;
import com.ewa.project.entity.Category;
import com.ewa.project.entity.Order;

public class ProductDto {

	private Long productId;

	@NotBlank
	private String productName;

	@NotBlank
	private String productDescription;

	@NotBlank
	private double productPrice;

	@NotBlank
	private String productImage;

	@NotBlank
	private String productSpecification;

	@NotBlank
	private String productBrand;

	// Relationships
	private Cart cart;
	private Order order;
	private List<Category> category;
	
	// getter and setter

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductSpecification() {
		return productSpecification;
	}

	public void setProductSpecification(String productSpecification) {
		this.productSpecification = productSpecification;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

}
