package com.comp303.lab3.controllers;

import com.comp303.lab3.models.Patient;
import com.comp303.lab3.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class WebController {

    @Autowired
    PatientService patientService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("patients", patientService.getAllPatient());
        return "index";
    }

    @GetMapping("/add-patient-page")
    public String addPatientPage(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patient";
    }

    @PostMapping("/add-patient")
    public Object addPatient(@Valid Patient patient, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add-patient";
        }
        patientService.addPatient(patient);
        return new RedirectView("/", false);
    }

    @GetMapping("/update-patient/{id}")
    public String updatePatientPage(@PathVariable("id") int id, Model model) throws Exception {
        Patient patient = patientService.getPatientById(id);
        model.addAttribute("patient", patient);
        return "update-patient";
    }

    @PostMapping("/update-patient/{id}")
    public Object updateEmployee(@PathVariable("id") int id, @Valid Patient patient,
                                       BindingResult bindingResult, Model model) throws Exception {
        patient.setId(id);
        if (bindingResult.hasErrors()) {
            return "update-patient";
        }
        patientService.updatePatient(patient);
        return new RedirectView("/", false);

    }

    @GetMapping("/delete-patient/{id}")
    public RedirectView deletePatient(@PathVariable("id") int id, Model model) throws Exception {
        patientService.deletePatient(id);
        return new RedirectView("/", false);
    }
}
