package com.MAXIMO.demo;

import java.io.IOException;
import java.util.Base64;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaximoController {
	  private static final String MAXIMO_API_URL = "https://bportaluri.com/wp-content/MaximoJavaDocs76/";
	    private static final String USERNAME = "your_username";
	    private static final String PASSWORD = "your_password";

	    @GetMapping("/maximo/assets")
	    public String retrieveAssetInformation() {
	        HttpClient httpClient = HttpClients.createDefault();
	        HttpGet request = new HttpGet(MAXIMO_API_URL + "maximo-rest");

	        // Add Basic Authentication headers
	        String credentials = USERNAME + ":" + PASSWORD;
	        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
	        request.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encodedCredentials);

	        try {
	            HttpResponse response = httpClient.execute(request);

	            // Check if the response status is OK (200)
	            if (response.getStatusLine().getStatusCode() == 200) {
	                HttpEntity entity = response.getEntity();
	                String json = EntityUtils.toString(entity);

	                // Parse JSON response
	                ObjectMapper objectMapper = new ObjectMapper();
	                JsonNode rootNode = objectMapper.readTree(json);

	                // Access asset details
	                JsonNode assetNode = rootNode.get("asset");
	                String assetDetails = assetNode.toPrettyString();
	                
	                // Print asset details in console
	                System.out.println("Asset details:");
	                System.out.println(assetDetails);

	                return assetDetails;
	            } else {
	                return "Failed to retrieve asset information. Status code: " + response.getStatusLine().getStatusCode();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "Error retrieving asset information from Maximo";
	        }
	    }

}
