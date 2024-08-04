package com.practice.inventorymanagement.item;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(this.itemService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> addItem(@RequestBody Item item) {
        this.itemService.save(item);
        return ResponseEntity.ok("Item added successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        boolean deleted = this.itemService.deleteById(id);
        if (deleted) {
            return ResponseEntity.ok("Item deleted successfully");
        }
        return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);
    }
}
