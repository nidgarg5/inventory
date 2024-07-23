package com.inventory.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.Hibernate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(unique = true)
    @NotBlank(message="Name cannot be blank")
    String name;
    
    //@NotBlank(message="Price cannot be blank")
    Double price;
    
    @Min(value = 1, message = "Quantity must be greater than 0")
    @NotNull
    Integer quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return id != null && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
    //Validation for name, price and quantity
    /*public List<String> validateProduct(Product product){
    	List<String> errorList = new ArrayList<String>();
    	if(product.name.equals("")) {
    		errorList.add("Product Name is Empty");
    	}
    	if(product.price.equals("") || product.price== 0.0) {
    		errorList.add("Product Price is Empty");
    	}
    	if(product.quantity== 0) {
    		errorList.add("Product Quantity is Zero");
    	}
    	return errorList;
    }*/
    
    
}
