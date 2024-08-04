package com.practice.inventorymanagement.purchase;

import com.practice.inventorymanagement.item.Item;
import com.practice.inventorymanagement.item.ItemService;
import com.practice.inventorymanagement.supplier.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;
    private final SupplierService supplierService;
    private final ItemService itemService;

    public PurchaseController(PurchaseService purchaseService,
                              SupplierService supplierService, ItemService itemService) {
        this.purchaseService = purchaseService;
        this.supplierService = supplierService;
        this.itemService = itemService;
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

    @GetMapping("/summary")
    public ResponseEntity<List<PurchaseSummary>> getPurchaseSummary() {
        return ResponseEntity.ok(this.purchaseService.getPurchaseSummary());
    }

    @GetMapping("/sample")
    public ResponseEntity<String> addSampleSuppliers() {
        Long[] sampleIds = {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L};
        Long[] sampleSupplierIds = {1L, 1L, 1L, 2L, 2L, 3L, 3L, 4L, 4L};
        Long[] sampleItemIds = {2L, 2L, 3L, 3L, 4L, 1L, 1L, 2L, 4L};
        Long[] sampleQuantity = {10L, 5L, 8L, 5L, 12L, 7L, 10L, 6L, 15L};
        LocalDateTime[] sampleDates = {
                LocalDateTime.parse("2024-07-15T09:30:00"),
                LocalDateTime.parse("2024-07-25T14:00:00"),
                LocalDateTime.parse("2024-08-01T11:15:00"),
                LocalDateTime.parse("2024-07-20T10:45:00"),
                LocalDateTime.parse("2024-08-05T16:30:00"),
                LocalDateTime.parse("2024-08-01T13:00:00"),
                LocalDateTime.parse("2024-08-10T09:00:00"),
                LocalDateTime.parse("2024-07-30T15:00:00"),
                LocalDateTime.parse("2024-08-03T08:30:00")
        };

        for(int i = 0; i < sampleIds.length; i++) {
            Item sampleItem = this.itemService.findById(sampleItemIds[i]);
            createPurchase(
                    new Purchase(
                            sampleIds[i],
                            this.supplierService.findById(sampleSupplierIds[i]),
                            sampleItem,
                            sampleQuantity[i],
                            sampleItem.getUnitPrice() * sampleQuantity[i],
                            sampleDates[i]
                    )
            );
        }
        return ResponseEntity.ok("Sample Purchases added successfully");
    }
}
