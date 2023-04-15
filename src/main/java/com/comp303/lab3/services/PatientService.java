package com.comp303.lab3.services;

import com.comp303.lab3.models.Patient;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface PatientService {
    public Iterable<Patient> getAllPatient();

    public Patient getPatientById(int patientId) throws Exception;

    void addPatient(Patient patient);

    void updatePatient(Patient patient) throws Exception;

    void deletePatient(int productId) throws Exception;

}
