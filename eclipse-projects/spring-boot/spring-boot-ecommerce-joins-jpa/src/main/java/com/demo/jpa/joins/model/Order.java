package com.demo.jpa.joins.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;

@Entity
public class Order {
	@Id
	@GeneratedValue
	private Long id;
	
	private Integer quantity;
	
	@Valid
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@Valid
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@AssertTrue(message = "Order can only be placed if customer has a valid name and the product is in stock")
	private boolean isValidOrder() {
		return (customer != null && customer.getName() != null && product != null && product.isInStock());
	}
}
