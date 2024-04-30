package com.Shipment.demo;

public class ProductNotFoundException extends RuntimeException {

	 
	        public ProductNotFoundException(int productId) {
	            super("Product with ID " + productId + " is unavailable or out of stock");
	        }
}
