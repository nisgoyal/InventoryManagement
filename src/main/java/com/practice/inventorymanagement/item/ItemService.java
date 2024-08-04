package com.practice.inventorymanagement.item;

import java.util.List;

public interface ItemService {
    List<Item> findAll();
    void save(Item item);
    boolean deleteById(Long id);
    Item findById(Long id);
}
