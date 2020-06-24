package com.inventory.inventorysystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "InventoryItem")
public class InventoryItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String category;
	private Long costPrice;
	private Integer sellingPrice;
	private Integer quantityInKg;

}
//name, category, cost price, selling
//price and quantity of items.
//Eg: Apple, produce, Rs.120.80, 125, 1kg