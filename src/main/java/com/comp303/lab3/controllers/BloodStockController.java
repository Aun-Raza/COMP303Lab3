package com.comp303.lab3.controllers;

import com.comp303.lab3.models.BloodStock;
import com.comp303.lab3.services.BloodStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class BloodStockController {
    @Autowired
    BloodStockService bloodStockService;

    @GetMapping("/api/bloodStock/getAllBloodStocks")
    public Iterable<BloodStock> getAllBloodStocks() {
        return bloodStockService.getAllBloodStock();
    }

    @GetMapping(value = "/api/bloodStock/getBloodStock/{bloodStockId}")
    public BloodStock getBloodStock(@PathVariable("bloodStockId") int bloodStockId) throws Exception {
        return bloodStockService.getBlockStockById(bloodStockId);
    }

    @PostMapping(value = "/api/bloodStock/addBloodStock", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBloodBank(@RequestBody BloodStock bloodStock) {
        bloodStockService.addBlockStock(bloodStock);
    }

    @RequestMapping(value = "/api/bloodStock/updateBloodStock", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateBloodStock(@RequestBody BloodStock bloodStock) throws Exception {
        bloodStockService.updateBlockStock(bloodStock);
    }

    @RequestMapping(value = "/api/bloodStock/deleteBloodStock/{bloodStockId}", method = RequestMethod.DELETE)
    public void deleteBloodBank(@PathVariable("bloodStockId") int bloodStockId) throws Exception {
        bloodStockService.deleteBlockStock(bloodStockId);
    }
}
