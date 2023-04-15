package com.comp303.lab3.services;

import com.comp303.lab3.models.BloodStock;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
public class BloodStockServiceImpl implements BloodStockService{
    HashMap<Integer, BloodStock> bloodStocks = new HashMap<Integer, BloodStock>();
    private static int ID = 4;

    public BloodStockServiceImpl() {
        bloodStocks.put(1, new BloodStock(1, "A", 14552, new Date(), false));
        bloodStocks.put(2, new BloodStock(2, "B", 996, new Date(), true));
        bloodStocks.put(3, new BloodStock(3, "AB", 122, new Date(), true));
    }

    @Override
    public Iterable<BloodStock> getAllBloodStock() {
        return bloodStocks.values();
    }

    @Override
    public BloodStock getBlockStockById(int blockStockId) throws Exception {
        if (!bloodStocks.containsKey(blockStockId)) {
            throw new Exception("Blood Stock doesn't exist");
        }
        return bloodStocks.get(blockStockId);
    }

    @Override
    public void addBlockStock(BloodStock bloodStock) {
        bloodStock.setId(ID);
        bloodStocks.put(ID, bloodStock);
        ID++;
    }

    @Override
    public void updateBlockStock(BloodStock bloodStock) throws Exception {
        if (!bloodStocks.containsKey(bloodStock.getId())) {
            throw new Exception("Blood Stock doesn't exist");
        }
        bloodStocks.put(bloodStock.getId(), bloodStock);
    }

    @Override
    public void deleteBlockStock(int blockStockId) throws Exception {
        if (!bloodStocks.containsKey(blockStockId)) {
            throw new Exception("Blood Stock doesn't exist");
        }
        bloodStocks.remove(blockStockId);
    }
}
