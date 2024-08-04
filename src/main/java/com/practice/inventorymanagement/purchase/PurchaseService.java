package com.practice.inventorymanagement.purchase;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PurchaseService {
    List<Purchase> findAll();
    boolean save(Purchase purchase);
}
