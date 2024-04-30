package com.Test.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private Map<Integer, Product> productMap = new HashMap<>();
    private Map<Integer, Product> cachedProducts = new HashMap<>();
    // Constructor to add some sample data
    public ProductService() {
    	
    	// Add sample clothing products
        Clothing clothing1 = new Clothing(1, "T-Shirt", 20.99, "XL", "Blue", "XYZ Brand");
        Clothing clothing2 = new Clothing(2, "Jeans", 39.99, "32", "Black", "ABC Brand");
        productMap.put(clothing1.getProductId(), clothing1);
        productMap.put(clothing2.getProductId(), clothing2);

        // Add sample electronics products
        Electronics electronics1 = new Electronics(3, "Smartphone", 499.99, "Samsung", "Galaxy S21");
        Electronics electronics2 = new Electronics(4, "Laptop", 999.99, "Dell", "XPS 13");
        productMap.put(electronics1.getProductId(), electronics1);
        productMap.put(electronics2.getProductId(), electronics2);
        
    }

    public void addProduct(Product product) {
        productMap.put(product.getProductId(), product);
        

    }

    public Product getProductById(int productId) {
        return productMap.get(productId);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }
    public Clothing getClothingDetails(int productId) {
    	  Product product = productMap.get(productId);
          if (product instanceof Clothing) {
              return (Clothing) product;
          } else {
              return null; 
          }
      
    }
    public void updateCachedProductData(Product product) {
        // Check if the product exists in the cache
        if (cachedProducts.containsKey(product.getProductId())) {
            // If the product exists, update its data in the cache
            cachedProducts.put(product.getProductId(), product);
        } else {
            // If the product does not exist, add it to the cache
            cachedProducts.put(product.getProductId(), product);
        }
    }
}
