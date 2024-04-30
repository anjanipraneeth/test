package com.Test.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    @Autowired
    InventoryService inventoryService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/clothing")
    public String addClothingProduct(@RequestBody Clothing clothing) {
        productService.addProduct(clothing);
        return "Clothing product added: " + clothing.getProductName();
    }

    @PostMapping("/electronics")
    public String addElectronicsProduct(@RequestBody Electronics electronics) {
        productService.addProduct(electronics);
        return "Electronics product added: " + electronics.getProductName();
    }

    @GetMapping("/product/{productId}")
    public Product getProductDetails(@PathVariable int productId) throws Exception {
    	 try {
             Product product = productService.getProductById(productId);
             if (product == null) {
                 throw new Exception("Product with ID " + productId + " is unavailable or out of stock");
             }
             return product;
         } catch (Exception  e) {
             throw new Exception(e.getMessage());
         }
     }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/clothinginventory")
    public String getTotalClothingCount() {
        return ("Total Clothing instock is "+inventoryService.getTotalClothingCount());
    }
    @GetMapping("/electronicsinventory")
    public String getTotalElectronicsCount() {
        return ("Total Electronics instock is "+inventoryService.getTotalElectronicsCount());
    }
  
}
