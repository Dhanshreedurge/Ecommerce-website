package com.ewa.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "Category_Details")
public class Category {

	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;

	@NotBlank
	@Column(name = "category_name")
	private String categoryName;

	// Relationships

	@ManyToMany(mappedBy = "category", cascade= CascadeType.ALL)
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
