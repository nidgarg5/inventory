package com.inventory.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.inventory.entities.Product;
import com.inventory.entities.RecalledProduct;
import com.inventory.helpers.ProductFilter;
import com.inventory.repositories.InventoryRepository;
import com.inventory.repositories.RecalledProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final InventoryRepository inventoryRepository;
    private final RecalledProductRepository recalledProductRepository;

    @Transactional
    public Product save(@Validated Product product) {
    	/*List<String> errorList = product.validateProduct(product);
    	if(!errorList.isEmpty()) {
    		throw new BusinessException("601","Product Details are not validated");
    	}*/
        return inventoryRepository.save(product);
    }
    
    public void deleteById(Integer id) {
        inventoryRepository.deleteById(id);
    }

    public Collection<Product> getAllProduct() {
    	List<RecalledProduct>  recalledProduct = recalledProductRepository.findAll();
    	HashSet<String> recalledProductNameList = (HashSet) recalledProduct.stream().map(n -> n.getName()).collect(Collectors.toSet());
        ProductFilter filter = new ProductFilter(recalledProductNameList);

        return filter.removeRecalledFrom(inventoryRepository.findAll());
    }

    public Optional<Product> findById(Integer id) {
        return inventoryRepository.findById(id);
    }
}
