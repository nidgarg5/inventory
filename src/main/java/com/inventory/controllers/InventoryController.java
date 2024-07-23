package com.inventory.controllers;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.entities.Product;
import com.inventory.services.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/inventory/product")
public class InventoryController {

    private final ProductService productService;

    /**
     *
     * @return all the products that are not recalled
     */
    @GetMapping
    public ResponseEntity<Collection<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProduct());
    }

    /**
     * Create new Product
     * @param product
     * @return
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    /**
     * Search the product
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    ResponseEntity<Product> findProduct(@PathVariable Integer id) {
        Optional<Product> byId = productService.findById(id);

        return byId.map(ResponseEntity::ok).orElse(null);
    }
    
    /**
     * Delete the product
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
    	Product p = productService.findById(id).get();
    	if(p!=null) {
    		 productService.deleteById(id);
        	 return ResponseEntity.status(HttpStatus.ACCEPTED).body("Product Deleted");
    	}
    	return ResponseEntity.notFound().build();
    	
 
    }
    
    /**
     * Update the product
     * @param product
     * @return
     */
    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }
}
