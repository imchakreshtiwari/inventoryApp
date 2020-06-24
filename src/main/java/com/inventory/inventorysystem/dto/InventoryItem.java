package com.inventory.inventorysystem.dto;

import lombok.Data;

@Data
public class InventoryItem {

	private Long id;
	private String name;
	private String category;
	private Long costPrice;
	private Integer sellingPrice;
	private Integer quantityInKg;

}
