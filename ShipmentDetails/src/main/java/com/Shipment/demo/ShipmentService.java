package com.Shipment.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.Test.demo.Product;

@Service
public class ShipmentService {

    private final String productBaseUrl = "http://localhost:8080/products/";
    
    @Autowired
    private RestTemplate restTemplate;
    
    public Product getProductById(int productId) {
        String getProductUrl = productBaseUrl + "product/" + productId;
        ResponseEntity<Product> response = restTemplate.exchange(getProductUrl, HttpMethod.GET, null, Product.class);
        return response.getBody();
    }
    public Product placeOrder(int productId) {
    	  Product product = getProductById(productId);
    	    if (product != null) {
    	        String placeOrderUrl = productBaseUrl + "clothing";
    	        HttpEntity<Product> request = new HttpEntity<>(product);
    	        restTemplate.postForObject(placeOrderUrl, request, String.class);
    	        return product;
    	    } else {
    	        throw new IllegalArgumentException("Product with ID " + productId + " does not exist");
    	    }
    }

    
}
