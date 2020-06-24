package com.inventory.inventorysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.inventorysystem.dto.InventoryItem;
import com.inventory.inventorysystem.service.InventoryItemService;

@RestController
public class InventoryItemController {

	@Autowired
	InventoryItemService inventoryItemService;

	@PostMapping(value = "/addItem")
	public ResponseEntity<?> addInvenToryItem(@RequestBody InventoryItem inventoryItem) {
		inventoryItemService.addItem(inventoryItem);
		return new ResponseEntity<>("Created", HttpStatus.OK);

	}

	@PutMapping(value = "/updateItem")
	public ResponseEntity<?> updateInvenToryItem(@RequestBody InventoryItem inventoryItem) {
		inventoryItemService.updateItem(inventoryItem);
		return new ResponseEntity<>("Updated", HttpStatus.OK);

	}

	@GetMapping(value = "/allItems")
	public ResponseEntity<?> getAllInvenToryItems() {
		List<InventoryItem> items = inventoryItemService.getItems();
		return new ResponseEntity<>(items, HttpStatus.OK);

	}

	@GetMapping(value = "/item/{id}")
	public ResponseEntity<?> getInvenToryItemById(@PathVariable("id") Long id) {

		InventoryItem item = inventoryItemService.getaItem(id);
		return new ResponseEntity<>(item, HttpStatus.OK);

	}

	@DeleteMapping(value = "/deleteItem/{id}")
	public ResponseEntity<?> deleteInvenToryItem(@PathVariable("id") Long id) {
		inventoryItemService.deleteItem(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}

}
