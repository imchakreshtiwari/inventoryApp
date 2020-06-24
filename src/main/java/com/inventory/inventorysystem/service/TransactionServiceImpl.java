package com.inventory.inventorysystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.inventorysystem.dto.Transaction;
import com.inventory.inventorysystem.entity.InventoryItemEntity;
import com.inventory.inventorysystem.entity.TransactionEntity;
import com.inventory.inventorysystem.exception.RecordNotFoundException;
import com.inventory.inventorysystem.repository.InventoryItemRepo;
import com.inventory.inventorysystem.repository.TransactionEntityRepo;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionEntityRepo transactionEntityRepo;
	
	@Autowired
	InventoryItemRepo inventoryItemRepo;

	@Override
	public Transaction buyItem(Transaction transaction) {
		String customerName = transaction.getCustomerName();
		Integer quantity = transaction.getQuantity();
		String itemName = transaction.getItemBought();
		
		InventoryItemEntity itemDetails = inventoryItemRepo.findByName(itemName);
		Integer	sellingPricePerkg = itemDetails.getSellingPrice();
		Long bill = (long) (quantity * sellingPricePerkg);
		
		
		//saving transaction details
		TransactionEntity transactionObj = new  TransactionEntity(customerName, itemName, quantity, sellingPricePerkg, bill);
		transactionEntityRepo.save(transactionObj);
		
		//getting bill for customer
		//Transaction transaction = new Transaction();
		transaction.setCustomerName(customerName);
		transaction.setItemBought(itemName);
		transaction.setQuantity(quantity);
		transaction.setSellingPricePerkg(sellingPricePerkg);
		transaction.setYourBill(bill);
		
		//updating inventory
		Integer remaiingQuantity = itemDetails.getQuantityInKg() - quantity;
		itemDetails.setQuantityInKg(remaiingQuantity);
		inventoryItemRepo.save(itemDetails);
		
		return transaction;
	}
	
	@Override
	public List<Transaction> getAllTransaction(){
		List<Transaction> transactionList = new ArrayList<Transaction>();
		List<TransactionEntity> transactionEntityList = transactionEntityRepo.findAll();
		transactionEntityList.forEach(transactionEntity ->{
			Transaction transaction = new Transaction();
			transaction.setCustomerName(transactionEntity.getCustomerName());
			transaction.setItemBought(transactionEntity.getItemBought());
			transaction.setQuantity(transactionEntity.getQuantity());
			transaction.setSellingPricePerkg(transactionEntity.getSellingPricePerkg());
			transaction.setYourBill(transactionEntity.getYourBill());
			transactionList.add(transaction);
		});
		return transactionList;
	}
	
	@Override
	public Transaction getTransaction(long id) {
		
		TransactionEntity	transactionEntity = transactionEntityRepo.findById(id).orElseThrow(() ->{
			throw new RecordNotFoundException("No Transaction details Found");
		});
		Transaction transaction = new Transaction();
		transaction.setCustomerName(transactionEntity.getCustomerName());
		transaction.setItemBought(transactionEntity.getItemBought());
		transaction.setQuantity(transactionEntity.getQuantity());
		transaction.setSellingPricePerkg(transactionEntity.getSellingPricePerkg());
		transaction.setYourBill(transactionEntity.getYourBill());
		return transaction;
	}
	
	
}
