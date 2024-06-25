package com.inventory.helpers;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.inventory.entities.Product;

public class ProductFilter {

    private static Set<String> recalledProducts;

    public ProductFilter(Set<String> recalledProducts) {
        ProductFilter.recalledProducts = recalledProducts;
    }

    public List<Product> removeRecalledFrom(Collection<Product> allProduct) {
        return allProduct.stream().filter(ProductFilter::filterByName).collect(Collectors.toList());
    }

    private static boolean filterByName(Product product) {
    	return !recalledProducts.contains(product.getName());
    }
}
