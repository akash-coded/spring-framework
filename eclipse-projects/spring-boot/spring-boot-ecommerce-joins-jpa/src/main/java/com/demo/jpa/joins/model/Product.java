package com.demo.jpa.joins.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank(message = "Product name is mandatory")
	@Size(min = 2, max = 50, message = "Product name must be between 2 and 50 characters")
	private String name;
	
	@NotNull(message = "Price is mandatory")
	@DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
	private Double price;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	/**
	 * Needs change
	 * @return Boolean
	 */
	public Boolean isInStock() {
		return true;
	}
}
