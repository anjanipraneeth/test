package com.Test.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
	@Autowired
	ProductService productService;
	   public int getTotalClothingCount() {
	        return getTotalProductCount(Clothing.class);
	    }

	    // Method to get the total number of electronics records
	    public int getTotalElectronicsCount() {
	        return getTotalProductCount(Electronics.class);
	    }
	   private int getTotalProductCount(Class<? extends Product> productType) {
	        List<Product> allProducts = productService.getAllProducts();
	        int count = 0;
	        for (Product product : allProducts) {
	            if (productType.isInstance(product)) {
	                count++;
	            }
	        }
	        return count;
	    }
	/*
	 * public int getTotalClothingCount() { List<Product> allProducts =
	 * productService.getAllProducts(); int clothingCount = 0; for (Product product
	 * : allProducts) { if (product instanceof Clothing) { clothingCount++; } }
	 * return clothingCount; }
	 */
}
	    
