package com.reyavaya.Reyavaya.Technologies.controllers;

import com.reyavaya.Reyavaya.Technologies.Exception.ResourceNotFoundException;
import com.reyavaya.Reyavaya.Technologies.model.Product;
import com.reyavaya.Reyavaya.Technologies.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody LinkedHashMap<String, String> product) {
        Product productObj = new Product(product.get("name"),
                product.get("brand"),
                Long.parseLong(product.get("supplier")),
                Double.parseDouble(product.get("purchasedPrice")),
                Double.parseDouble(product.get("sellingPrice")));
        System.out.println(product);
        return productRepository.save(productObj);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Product with id "+id+" does not exist"
        ));
        return ResponseEntity.ok(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        Product productObj = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Product with id "+id+" does not exist"));
        productObj.setName(product.getName());
        productObj.setBrand(product.getBrand());
        productObj.setSupplier(product.getSupplier());
        productObj.setPurchasedPrice(product.getPurchasedPrice());
        productObj.setSellingPrice(product.getSellingPrice());

        Product updatedProduct = productRepository.save(productObj);
        return ResponseEntity.ok(updatedProduct);

    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
                "Product with id "+id+" doe not exist"));
        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}
