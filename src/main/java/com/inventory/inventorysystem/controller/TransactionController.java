package com.inventory.inventorysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.inventorysystem.dto.Transaction;
import com.inventory.inventorysystem.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@PostMapping(value = "/buyItem")
	public ResponseEntity<?> buyItem(@RequestBody Transaction transaction) {
		
		Transaction transactionDetails = transactionService.buyItem(transaction);
		return new ResponseEntity<>(transactionDetails, HttpStatus.OK);
	}

	@GetMapping(value = "/allTransactions")
	public ResponseEntity<?> getAllTransactions() {
		
		List<Transaction> transactions = transactionService.getAllTransaction();
		return new ResponseEntity<>(transactions, HttpStatus.OK);
	}

	@GetMapping(value = "/transaction/{id}")
	public ResponseEntity<?> getTransactionByID(@PathVariable("id") Long id) {

		Transaction transaction = transactionService.getTransaction(id);
		return new ResponseEntity<>(transaction, HttpStatus.OK);
	}

}
