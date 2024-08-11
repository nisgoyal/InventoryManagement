package com.practice.inventorymanagement.purchase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    @Query(
            "SELECT new com.practice.inventorymanagement.purchase.PurchaseSummary(" +
                    "p.supplier, p.item, SUM(p.quantity), MONTH(p.dateOfP), SUM(p.amount))" +
                    "FROM Purchase p " +
                    "GROUP BY p.supplier, p.item, MONTH(p.dateOfP)" +
                    "ORDER BY MONTH(p.dateOfP)"
    )
    List<PurchaseSummary> getPurchaseSummaries();
}
