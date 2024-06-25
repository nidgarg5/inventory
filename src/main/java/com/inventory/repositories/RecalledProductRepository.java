package com.inventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.entities.RecalledProduct;


@Repository
public interface RecalledProductRepository extends JpaRepository<RecalledProduct, Integer> {}
