package com.comp303.lab3.services;

import com.comp303.lab3.models.BloodBank;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BloodBankServiceImpl implements BloodBankService{
    HashMap<Integer, BloodBank> bloodBanks = new HashMap<Integer, BloodBank>();
    private static int ID = 4;

    public BloodBankServiceImpl() {
        bloodBanks.put(1, new BloodBank(1, "SVB", "Fake Street", "San Francisco",
                123, "website.com", "iStoleYourSavings@gmail.com"));
        bloodBanks.put(2, new BloodBank(2, "Signature Bank", "Fake Street", "New York",
                123, "website.com", "iStoleYourSavings@gmail.com"));
        bloodBanks.put(3, new BloodBank(3, "RBC Royal Bank", "Fake Street", "Toronto",
                123, "website.com", "iStoleYourSavings@gmail.com"));
    }
    @Override
    public Iterable<BloodBank> getAllBloodBank() {
        return bloodBanks.values();
    }

    @Override
    public BloodBank getBlockBankById(int bloodBankId) throws Exception {
        if (!bloodBanks.containsKey(bloodBankId)) {
            throw new Exception("Blood Bank doesn't exist");
        }
        return bloodBanks.get(bloodBankId);
    }

    @Override
    public void addBlockBank(BloodBank bloodBank) {
        bloodBank.setId(ID);
        bloodBanks.put(ID, bloodBank);
        ID++;
    }

    @Override
    public void updateBlockBank(BloodBank bloodBank) throws Exception {
        if (!bloodBanks.containsKey(bloodBank.getId())) {
            throw new Exception("Blood Bank doesn't exist");
        }
        bloodBanks.put(bloodBank.getId(), bloodBank);
    }

    @Override
    public void deleteBlockBank(int blockBankId) throws Exception {
        if (!bloodBanks.containsKey(blockBankId)) {
            throw new Exception("Blood Bank doesn't exist");
        }
        bloodBanks.remove(blockBankId);
    }
}
