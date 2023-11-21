package com.ewa.project.model;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.ewa.project.entity.Customer;
import com.ewa.project.entity.Order;
import com.ewa.project.entity.Product;

public class CartDto {

	private Long cartId;

	@NotBlank
	private int quantity;

	@NotBlank
	private double totalPrice;
	
	private Customer customer;
	private List<Product> product;
	private Order order;
	
	//getter and setter
	
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}
