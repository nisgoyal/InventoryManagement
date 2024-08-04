package com.practice.inventorymanagement.purchase;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchases() {
        return ResponseEntity.ok(this.purchaseService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createPurchase(@RequestBody Purchase purchase) {
        boolean added = this.purchaseService.save(purchase);
        if (added) {
            return ResponseEntity.ok("Purchase created");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
