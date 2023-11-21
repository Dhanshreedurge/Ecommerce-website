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
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Entity
@Table(name = "Cart_Details")
public class Cart {
	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;

	@Column(name = "product_quantity")
	private int quantity;

	@Column(name = "total_price")
	private double totalPrice;

	// Relationships
	
	@OneToOne(mappedBy = "cart", cascade= CascadeType.ALL)
	private Customer customer;

	@OneToMany(mappedBy = "cart", cascade= CascadeType.ALL)
	private List<Product> product;
	
	@OneToOne
	@JoinColumn(name = "order_id")
	private Order order;

	// getter and setter
	
	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
