package com.cqrs.query.demo;

public class ProductEvent {
	
	

 
    private String type;
    private Product product;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
	@Override
	public String toString() {
		return "ProductEvent [type=" + type + ", product=" + product + "]";
	}
    
    
}

