package com.example.ecommerce.aggregator;

public class AggregateData {
    private ProductData productData;
    private UserData userData;
    
    public AggregateData(ProductData productData, UserData userData) {
        this.productData = productData;
        this.userData = userData;
    }
    
 // Getters and setters

    public ProductData getProductData() {
        return productData;
    }

    public void setProductData(ProductData productData) {
        this.productData = productData;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
