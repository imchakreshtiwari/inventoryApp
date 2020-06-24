package com.inventory.inventorysystem.dto;

import lombok.Data;

@Data
public class Transaction {

	private long id;
	private String customerName;
	private String itemBought;
	private Integer quantity;
	private Integer sellingPricePerkg;
	private Long yourBill;
}
