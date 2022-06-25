package com.aivaz.patientscrud.contoller;

import com.aivaz.patientscrud.model.Patient;
import com.aivaz.patientscrud.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patients")
    public String getAll(Model model) {
        List<Patient> patientList = patientService.getAll();
/*        if (patientList == null) {
            throw new RuntimeException("s");
        }*/
        model.addAttribute("patientList", patientList);
        return "patient-list";
    }

    @GetMapping("/patient-create")
    public String createPatientForm(Patient patient) {
        return "patient-create";
    }

    @PostMapping("/patient-create")
    public String createPatient(Patient patient) {
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/patient-delete/{id}")
    public String deletePatient(@PathVariable("id") Long id) {
        patientService.deletePatient(id);
        return "redirect:/patients";
    }


    @GetMapping("/patient-update/{id}")
    public String updatePatientForm(@PathVariable("id") Long id, Model model){
        Patient patient = patientService.getById(id);
        model.addAttribute("patient", patient);
        return "patient-update";
    }

    @PostMapping("/patient-update")
    public String updatePatient(Patient patient){
        patientService.savePatient(patient);
        return "redirect:/patients";
    }

}
