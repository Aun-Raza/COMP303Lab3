package com.comp303.lab3.services;

import com.comp303.lab3.models.BloodStock;

public interface BloodStockService {
    public Iterable<BloodStock> getAllBloodStock();

    public BloodStock getBlockStockById(int blockStockId) throws Exception;

    void addBlockStock(BloodStock bloodStock);

    void updateBlockStock(BloodStock bloodStock) throws Exception;

    void deleteBlockStock(int blockStockId) throws Exception;
}
