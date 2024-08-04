package com.practice.inventorymanagement.purchase.impl;

import com.practice.inventorymanagement.item.Item;
import com.practice.inventorymanagement.item.ItemRepository;
import com.practice.inventorymanagement.purchase.Purchase;
import com.practice.inventorymanagement.purchase.PurchaseRepository;
import com.practice.inventorymanagement.purchase.PurchaseService;
import com.practice.inventorymanagement.purchase.PurchaseSummary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final ItemRepository itemRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, ItemRepository itemRepository) {
        this.purchaseRepository = purchaseRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Purchase> findAll() {
        return this.purchaseRepository.findAll();
    }

    @Override
    public boolean save(Purchase purchase) {
        Item item = itemRepository.findById(purchase.getItem().getId()).orElse(null);
        if (item != null) {
            purchase.setAmount(
                    item.getUnitPrice() * purchase.getQuantity()
            );
            this.purchaseRepository.save(purchase);
            return true;
        }
        return false;
    }

    @Override
    public List<PurchaseSummary> getPurchaseSummary() {
        return this.purchaseRepository.getPurchaseSummaries();
    }
}
