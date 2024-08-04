package com.practice.inventorymanagement.item.impl;

import com.practice.inventorymanagement.item.Item;
import com.practice.inventorymanagement.item.ItemRepository;
import com.practice.inventorymanagement.item.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> findAll() {
        return this.itemRepository.findAll();
    }

    @Override
    public void save(Item item) {
        this.itemRepository.save(item);
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            this.itemRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public Item findById(Long id) {
        return this.itemRepository.findById(id).orElse(null);
    }
}
