package com.inventory.inventorysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.inventorysystem.entity.TransactionEntity;

@Repository
public interface TransactionEntityRepo extends JpaRepository<TransactionEntity, Long> {

}
