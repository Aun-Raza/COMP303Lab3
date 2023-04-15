package com.comp303.lab3.controllers;

import com.comp303.lab3.models.BloodBank;
import com.comp303.lab3.services.BloodBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class BloodBankController {
    @Autowired
    BloodBankService bloodBankService;

    @GetMapping("/api/bloodBank/getAllBloodBanks")
    public Iterable<BloodBank> getAllBloodBanks() {
        return bloodBankService.getAllBloodBank();
    }

    @GetMapping(value = "/api/bloodBank/getBloodBank/{bloodBankId}")
    public BloodBank getBloodBank(@PathVariable("bloodBankId") int bloodBankId) throws Exception {
        return bloodBankService.getBlockBankById(bloodBankId);
    }

    @PostMapping(value = "/api/bloodBank/addBloodBank", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addBloodBank(@RequestBody BloodBank bloodBank) {
        bloodBankService.addBlockBank(bloodBank);
    }

    @RequestMapping(value = "/api/bloodBank/updateBloodBank", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateBloodBank(@RequestBody BloodBank bloodBank) throws Exception {
        bloodBankService.updateBlockBank(bloodBank);
    }

    @RequestMapping(value = "/api/bloodBank/deleteBloodBank/{bloodBankId}", method = RequestMethod.DELETE)
    public void deleteBloodBank(@PathVariable("bloodBankId") int bloodBankId) throws Exception {
        bloodBankService.deleteBlockBank(bloodBankId);
    }
}
