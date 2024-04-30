package com.Test.demo;

public class Electronics extends Product {
	private String brand;
    private String model;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Electronics(int productId, String productName, double productPrice, String brand, String model) {
		super(productId, productName, productPrice);
		this.brand = brand;
		this.model = model;
	}
	public Electronics(int productId, String productName, double productPrice) {
		super(productId, productName, productPrice);
	}

	public Electronics() {
		
	}
}
