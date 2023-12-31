package com.ewa.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "customer_details")
public class Customer {
	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	@NotBlank
	@Column(name = "customer_first_name")
	private String customerFirstName;

	@NotBlank
	@Column(name = "customer_last_name")
	private String customerLastName;

	@NotBlank
	@Email
	@Column(name = "customer_email")
	private String customerEmail;

	@NotBlank
	@Size(min = 6, max = 20, message = "Password must be between 6 to 20 characters")
	@Column(name = "customer_password")
	private String customerPassword;

	@NotBlank
	@Column(name = "customer_address")
	private String customerAddress;

	@NotBlank
	@Size(min = 10, max = 10, message = "Contact number must have exactly 10 Numbers")
	@Column(name = "customer_phone_no")
	private String customerPhoneNo;

	// Relationships
//	, referencedColumnName = "cart_id"
	@OneToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@OneToMany(mappedBy = "customer", cascade= CascadeType.ALL)
	private List<Order> orders;

	@OneToMany(mappedBy = "customer", cascade= CascadeType.ALL)
	private List<Payment> payments;
	
	// getter and setter

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhoneNo() {
		return customerPhoneNo;
	}

	public void setCustomerPhoneNo(String customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

}
