package com.comp303.lab3.controllers;

import com.comp303.lab3.models.Patient;
import com.comp303.lab3.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    /* THYMELEAF CONTROLLER */



    @GetMapping("/api/patient/getAllPatient")
    public Iterable<Patient> getAllPatient() {
        return patientService.getAllPatient();
    }

    @GetMapping(value = "/api/patient/getPatient/{patientId}")
    public Patient getPatientById(@PathVariable("patientId") int patientId) throws Exception {
        return patientService.getPatientById(patientId);
    }

    @PostMapping(value = "/api/patient/addPatient", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void savePatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @RequestMapping(value = "/api/patient/updatePatient", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updatePatient(@RequestBody Patient patient) throws Exception {
        patientService.updatePatient(patient);
    }

    @RequestMapping(value = "/api/patient/deletePatient/{patientId}", method = RequestMethod.DELETE)
    public void deleteProductDetail(@PathVariable("patientId") int patientId) throws Exception {
        patientService.deletePatient(patientId);
    }
}
