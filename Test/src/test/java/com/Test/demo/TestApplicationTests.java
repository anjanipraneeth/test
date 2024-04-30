package com.Test.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class TestApplicationTests {

	@Test
	void contextLoads() {
	}
	  @Autowired
	    private MockMvc mockMvc;
	  @Test
	    public void testGetProductDetails_ValidProductId() throws Exception {
	        int productId = 1; // Specify a valid product ID for testing
	        mockMvc.perform(get("/products/product/{productId}", productId))
	               .andExpect(status().isOk())
	               .andExpect(jsonPath("$.productId").value(productId));
	    }

	  @Test
	  public void testGetProductDetails_InvalidProductId() throws Exception {
	      int invalidProductId = 1000; // Specify an invalid product ID for testing
	      try {
	          mockMvc.perform(get("/products/product/{productId}", invalidProductId))
	                 .andExpect(status().isNotFound());
	      } catch (NestedServletException e) {
	          Throwable resolvedException = e.getRootCause();
	          assertNotNull(resolvedException);
	          assertEquals("Product with ID " + invalidProductId + " is unavailable or out of stock",
	                       resolvedException.getMessage());
	      }
	  }
	    @Test
	    public void testAddClothingProduct() throws Exception {
	        String requestBody = "{\"productId\": 100, \"productName\": \"Test Clothing\", \"productPrice\": 29.99, \"size\": \"XL\", \"color\": \"Red\", \"clothingBrandName\": \"Test Brand\"}";
	        mockMvc.perform(post("/products/clothing").content(requestBody).contentType("application/json"))
	               .andExpect(status().isOk())
	               .andExpect(content().string("Clothing product added: Test Clothing"));
	    }

	    @Test
	    public void testAddElectronicsProduct() throws Exception {
	        String requestBody = "{\"productId\": 200, \"productName\": \"Test Electronics\", \"productPrice\": 499.99, \"manufacturer\": \"Test Manufacturer\", \"model\": \"Test Model\"}";
	        mockMvc.perform(post("/products/electronics").content(requestBody).contentType("application/json"))
	               .andExpect(status().isOk())
	               .andExpect(content().string("Electronics product added: Test Electronics"));
	    }


}
