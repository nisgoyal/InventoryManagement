package com.practice.inventorymanagement.supplier.impl;

import com.practice.inventorymanagement.supplier.Supplier;
import com.practice.inventorymanagement.supplier.SupplierRepository;
import com.practice.inventorymanagement.supplier.SupplierService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public boolean delete(Long id) {
        try {
            supplierRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public Supplier findById(Long id) {
        return supplierRepository.findById(id).orElseGet(null);
    }

}
