package com.practice.inventorymanagement.supplier;

import java.util.List;

public interface SupplierService {

    List<Supplier> findAll();
    void save(Supplier supplier);
    boolean delete(Long id);
}
