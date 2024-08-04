package com.practice.inventorymanagement.supplier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    SupplierService supplierService;
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> addSupplier(@RequestBody Supplier supplier) {
        this.supplierService.save(supplier);
        return ResponseEntity.ok("Supplier added successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Long id) {
        boolean deleted = this.supplierService.delete(id);
        if (deleted) {
            return new ResponseEntity<>("Supplier deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Supplier not found", HttpStatus.NOT_FOUND);
    }
}