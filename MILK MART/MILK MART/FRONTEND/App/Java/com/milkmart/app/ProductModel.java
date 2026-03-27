package com.milkmart.app;

public class ProductModel {
    private String productName;
    private String productPrice;
    private String productImageUri; // Phone ki gallery ka path

    public ProductModel(String productName, String productPrice, String productImageUri) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productImageUri = productImageUri;
    }

    public String getProductName() { return productName; }
    public String getProductPrice() { return productPrice; }
    public String getProductImageUri() { return productImageUri; }
}
