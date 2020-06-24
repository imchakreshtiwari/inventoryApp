package com.inventory.inventorysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.inventorysystem.entity.InventoryItemEntity;

@Repository
public interface InventoryItemRepo extends JpaRepository<InventoryItemEntity, Long> {
	
	InventoryItemEntity	findByName(String itemName);
}
