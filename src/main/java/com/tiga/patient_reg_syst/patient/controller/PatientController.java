package com.tiga.patient_reg_syst.patient.controller;


import com.tiga.patient_reg_syst.patient.dto.PatientQueryResponse;
import com.tiga.patient_reg_syst.patient.dto.PatientResponse;
import com.tiga.patient_reg_syst.patient.entity.Patient;
import com.tiga.patient_reg_syst.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/patient")
public class PatientController {

    private PatientService patientService;


    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;


    }

    @GetMapping("/")
    public List<PatientResponse> findAll(){
        return patientService.findAll();
    }

    @GetMapping("/{patientId}")
    public PatientResponse findById(@PathVariable long patientId){
        return patientService.findById(patientId);
    }

    @GetMapping("/findByName/{name}")
    public List<PatientQueryResponse> findByName(@PathVariable String name){
        return patientService.findByName(name);
    }

    @GetMapping("/findBySurname/{surname}")
    public List<PatientQueryResponse> findBySurname(@PathVariable String surname){
        return patientService.findBySurname(surname);
    }

    @GetMapping("/filterByGender/{gender}")
    public List<PatientQueryResponse> findByGender(@PathVariable String gender){
        return patientService.filterByGender(gender);
    }
    @GetMapping("/filterByAge/{age}")
    public List<PatientQueryResponse> findByAge(@PathVariable Integer age){
        return patientService.filterByAge(age);
    }

    @GetMapping("/orderByBirthDateAsc")
    public List<PatientQueryResponse> orderByBirthDateAsc(){
        return patientService.orderByBirthDateAsc();
    }

    @GetMapping("/orderByAge")
    public List<PatientQueryResponse> orderByAge(){
        return patientService.orderByAge();
    }

    @PostMapping("/")
    public PatientResponse save(@RequestBody Patient patient){
        patientService.deleteDuplicatePatient();
        return patientService.save(patient);
    }

    @PutMapping("/{patientId}")
    public PatientResponse update(@PathVariable long patientId, @RequestBody Patient patient){
        patientService.deleteDuplicatePatient();
        return patientService.update(patientId,patient);
    }

    @DeleteMapping("/{patientId}")
    public PatientResponse delete (@PathVariable long patientId){
        return patientService.delete(patientId);
    }








}
