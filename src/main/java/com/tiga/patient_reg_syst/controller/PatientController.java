package com.tiga.patient_reg_syst.controller;

import com.tiga.patient_reg_syst.dto.PatientResponse;
import com.tiga.patient_reg_syst.entity.Patient;
import com.tiga.patient_reg_syst.service.PatientService;
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

    @PostMapping("/")
    public PatientResponse save(@RequestBody Patient patient){
        return patientService.save(patient);
    }

    @PutMapping("/{patientId}")
    public PatientResponse update(@PathVariable long patientId, @RequestBody Patient patient){
        return patientService.update(patientId,patient);
    }

    @DeleteMapping("/{patientId}")
    public PatientResponse delete (@PathVariable long patientId){
        return patientService.delete(patientId);
    }








}
