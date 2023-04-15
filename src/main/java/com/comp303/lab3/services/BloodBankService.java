package com.comp303.lab3.services;

import com.comp303.lab3.models.BloodBank;

public interface BloodBankService {
    public Iterable<BloodBank> getAllBloodBank();

    public BloodBank getBlockBankById(int bloodBankId) throws Exception;

    void addBlockBank(BloodBank bloodBank);

    void updateBlockBank(BloodBank bloodBank) throws Exception;

    void deleteBlockBank(int bloodBankId) throws Exception;
}
