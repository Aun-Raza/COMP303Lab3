package com.comp303.lab3.services;

import com.comp303.lab3.models.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class PatientServiceImpl implements PatientService {
    HashMap<Integer, Patient> patients = new HashMap<Integer, Patient>();
    private static int ID = 4;

    public PatientServiceImpl() {
        patients.put(1, new Patient(1, "Aun", "Raza",
                23, "Male", "B",
                "Toronto", 123));
        patients.put(2, new Patient(2, "Bob", "Jones",
                34, "Male", "A",
                "Vancouver", 123));
        patients.put(3, new Patient(3, "Isabella", "Surname",
                21, "Female", "AB",
                "Toronto", 123));
    }

    @Override
    public Iterable<Patient> getAllPatient() {
        return patients.values();
    }

    @Override
    public Patient getPatientById(int patientId) throws Exception {
        if (!patients.containsKey(patientId)) {
            throw new Exception("Patient doesn't exist");
        }
        return patients.get(patientId);
    }

    @Override
    public void addPatient(Patient patient) {
        patient.setId(ID);
        patients.put(ID, patient);
        ID++;
    }

    @Override
    public void updatePatient(Patient patient) throws Exception {
       if (!patients.containsKey(patient.getId())) {
           throw new Exception("Patient doesn't exist");
       }
       patients.put(patient.getId(), patient);
    }

    @Override
    public void deletePatient(int productId) throws Exception {
        if (!patients.containsKey(productId)) {
            throw new Exception("Patient doesn't exist");
        }
        patients.remove(productId);
    }
}
