package com.inventory.inventorysystem.service;

import java.util.List;

import com.inventory.inventorysystem.dto.InventoryItem;

public interface InventoryItemService {

	public void addItem(InventoryItem inventoryItem);

	public void updateItem(InventoryItem inventoryItem);

	public List<InventoryItem> getItems();

	public InventoryItem getaItem(Long id);

	public void deleteItem(Long id);

}
