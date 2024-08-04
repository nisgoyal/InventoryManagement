package com.practice.inventorymanagement.purchase;

import com.practice.inventorymanagement.item.Item;
import com.practice.inventorymanagement.supplier.Supplier;

public class PurchaseSummary {

    private Supplier supplier;
    private Item item;
    private Long quantity;
    private int month;
    private Double amount;

    public PurchaseSummary(Supplier supplier, Item item, Long quantity, int month, Double amount) {
        this.supplier = supplier;
        this.item = item;
        this.quantity = quantity;
        this.month = month;
        this.amount = amount;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
