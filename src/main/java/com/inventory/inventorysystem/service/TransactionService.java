package com.inventory.inventorysystem.service;

import java.util.List;

import com.inventory.inventorysystem.dto.Transaction;

public interface TransactionService {

	public Transaction buyItem(Transaction transaction);
	
	public List<Transaction> getAllTransaction();
	
	public Transaction getTransaction(long id);
}
