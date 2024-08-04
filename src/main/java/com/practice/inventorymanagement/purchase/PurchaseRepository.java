package com.practice.inventorymanagement.purchase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    @Query(
            "SELECT new com.practice.inventorymanagement.purchase.PurchaseSummary(" +
                    "p.supplier, p.item, SUM(p.quantity), MONTH(p.date), SUM(p.amount))" +
                    "FROM Purchase p " +
                    "GROUP BY p.supplier.id, p.item.id, MONTH(p.date)" +
                    "ORDER BY MONTH(p.date)"
    )
    List<PurchaseSummary> getPurchaseSummaries();
}
