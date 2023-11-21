package com.ewa.project.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "Product_Details")
public class Product {
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@NotBlank
	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_description")
	private String productDescription;

	@Column(name = "product_price")
	private double productPrice;

	@Column(name = "product_image")
	private String productImage;

	@Column(name = "product_specification")
	private String productSpecification;

	@Column(name = "product_brand")
	private String productBrand;

	// relationships
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@ManyToOne
	@JoinColumn(name = "order_id") // This is the foreign key in the product table
	private Order order;

	@ManyToMany
	@JoinColumn(name = "category_id")
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
