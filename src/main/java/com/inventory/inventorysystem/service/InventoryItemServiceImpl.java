package com.inventory.inventorysystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.inventorysystem.dto.InventoryItem;
import com.inventory.inventorysystem.entity.InventoryItemEntity;
import com.inventory.inventorysystem.exception.RecordNotFoundException;
import com.inventory.inventorysystem.repository.InventoryItemRepo;

@Service
public class InventoryItemServiceImpl implements InventoryItemService {

	@Autowired
	InventoryItemRepo inventoryItemRepo;

	@Override
	public void addItem(InventoryItem inventoryItem) {
		InventoryItemEntity inventoryItemEntity = new InventoryItemEntity();
		inventoryItemEntity.setName(inventoryItem.getName());
		inventoryItemEntity.setCategory(inventoryItem.getCategory());
		inventoryItemEntity.setCostPrice(inventoryItem.getCostPrice());
		inventoryItemEntity.setSellingPrice(inventoryItem.getSellingPrice());
		inventoryItemEntity.setQuantityInKg(inventoryItem.getQuantityInKg());
		inventoryItemRepo.save(inventoryItemEntity);
	}

	@Override
	public void updateItem(InventoryItem inventoryItem) {

		InventoryItemEntity inventoryItemEntity = new InventoryItemEntity();
		inventoryItemEntity.setId(inventoryItem.getId());
		inventoryItemEntity.setName(inventoryItem.getName());
		inventoryItemEntity.setCategory(inventoryItem.getCategory());
		inventoryItemEntity.setCostPrice(inventoryItem.getCostPrice());
		inventoryItemEntity.setSellingPrice(inventoryItem.getSellingPrice());
		inventoryItemEntity.setQuantityInKg(inventoryItem.getQuantityInKg());
		inventoryItemRepo.save(inventoryItemEntity);
	}

	@Override
	public List<InventoryItem> getItems() {

		List<InventoryItem> items = new ArrayList<InventoryItem>();
		List<InventoryItemEntity> inventoryItems = inventoryItemRepo.findAll();
		inventoryItems.forEach(inventoryItem -> {
			InventoryItem item = new InventoryItem();
			item.setId(inventoryItem.getId());
			item.setName(inventoryItem.getName());
			item.setCategory(inventoryItem.getCategory());
			item.setCostPrice(inventoryItem.getCostPrice());
			item.setSellingPrice(inventoryItem.getSellingPrice());
			item.setQuantityInKg(inventoryItem.getQuantityInKg());
			items.add(item);
		});
		return items;
	}

	@Override
	public InventoryItem getaItem(Long id) {
		InventoryItemEntity inventoryItemEntity = inventoryItemRepo.findById(id).orElseThrow(() -> {
			throw new RecordNotFoundException("Item Not Found For Given Id");
		});
		InventoryItem item = new InventoryItem();
		item.setId(inventoryItemEntity.getId());
		item.setName(inventoryItemEntity.getName());
		item.setCategory(inventoryItemEntity.getCategory());
		item.setCostPrice(inventoryItemEntity.getCostPrice());
		item.setSellingPrice(inventoryItemEntity.getSellingPrice());
		item.setQuantityInKg(inventoryItemEntity.getQuantityInKg());
		return item;
	}

	@Override
	public void deleteItem(Long id) {
		inventoryItemRepo.deleteById(id);
	}

}
