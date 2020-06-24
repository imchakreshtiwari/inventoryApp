package com.inventory.inventorysystem.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TransactionEntity")
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String customerName;
	private String itemBought;
	private Integer quantity;
	private Integer sellingPricePerkg;
	private Long yourBill;

	public TransactionEntity() {
		
	}
	public TransactionEntity(String customerName, String itemBought, Integer quantity, Integer sellingPricePerkg,
			Long yourBill) {
		this.customerName = customerName;
		this.itemBought = itemBought;
		this.quantity = quantity;
		this.sellingPricePerkg = sellingPricePerkg;
		this.yourBill = yourBill;
	}
}
