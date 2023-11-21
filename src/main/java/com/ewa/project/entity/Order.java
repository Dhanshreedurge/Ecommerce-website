package com.ewa.project.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "order_details")
public class Order {
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@NotBlank
	@Column(name = "order_status")
	private String orderStatus;

	@Column(name = "order_quantity")
	private int orderQuantity;

	@Column(name = "order_total_price")
	private double orderTotalPrice;
	
	// Relationships
	
	@OneToOne(mappedBy = "order", cascade= CascadeType.ALL)
	private Cart cart;

	@ManyToOne
	@JoinColumn(name = "customer_id") // Name of the foreign key column
	private Customer customer;

	@OneToMany(mappedBy = "order")
	private List<Product> products;

	@OneToOne
	@JoinColumn(name = "payment_id") // Name of the foreign key column in the order table
	private Payment payment;
	
	// getter and setter

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
