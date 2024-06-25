package com.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.entities.Product;


@Repository
public interface InventoryRepository extends JpaRepository<Product, Integer> {}
