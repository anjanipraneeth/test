package com.Shipment.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Test.demo.Product;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {
	 private final ShipmentService shipmentService;
	
	    @Autowired
	    public ShipmentController(ShipmentService shipmentService) {
	        this.shipmentService = shipmentService;
	    }

	    @PostMapping("/placeOrder/{productId}")
	    public ResponseEntity<String> placeOrder(@PathVariable int productId) {
	        try {
	            // Place the order and get the product details
	            Product orderedProduct = shipmentService.placeOrder(productId);
	            String responseMessage = "Order placed successfully. Product Details: " + orderedProduct.toString();
	            return ResponseEntity.ok(responseMessage);
	        } catch (IllegalArgumentException e) {
	            // Handle unsupported product type
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unsupported product type");
	        } catch (ProductNotFoundException e) {
	            // Handle product not found exception
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        } catch (Exception e) {
	            // Handle other exceptions
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Coudlnt place the order or Currently "+productId+ " is out of stock ");
	        }
	    }
	   
	    }


	    

