package com.cqrs.command.demo;

public class ProductEvent {

    ProductEvent(String type,Product product){

        this.type = type;
        this.product = product;
    }
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
    
}

