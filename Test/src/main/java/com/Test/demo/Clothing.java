package com.Test.demo;

public class Clothing extends Product {
	 	private String size;
	    private String color;
	    private String clothingBrandName;
		public String getSize() {
			return size;
		}
		public void setSize(String size) {
			this.size = size;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getClothingBrandName() {
			return clothingBrandName;
		}
		public void setClothingBrandName(String clothingBrandName) {
			this.clothingBrandName = clothingBrandName;
		}
		public Clothing(int productId, String productName, double productPrice, String size, String color,
				String clothingBrandName) {
			super(productId, productName, productPrice);
			this.size = size;
			this.color = color;
			this.clothingBrandName = clothingBrandName;
		}
		public Clothing(int productId, String productName, double productPrice) {
			super(productId, productName, productPrice);
		}
		  public Clothing() {
		        // Default constructor required by Jackson for deserialization
		    }
		
	    
}
