package com.ewa.project.model;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.ewa.project.entity.Cart;
import com.ewa.project.entity.Customer;
import com.ewa.project.entity.Payment;
import com.ewa.project.entity.Product;

public class OrderDto {

	private Long orderId;

	@NotBlank(message = "Enter valid orderStatus")
	private String orderStatus;

	@NotNull(message = "Enter valid orderQuantity")
	private int orderQuantity;

	@NotNull(message = "Enter valid orderTotalPrice")
	private double orderTotalPrice;

	// Relationships
	private Cart cart;
	private Customer customer;
	private List<Product> products;
	private Payment payment;
	
	//getter and setter

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public double getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}
