package com.tiga.patient_reg_syst.service;

import com.tiga.patient_reg_syst.dto.PatientResponse;
import com.tiga.patient_reg_syst.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PatientService{

    List<PatientResponse> findAll();

    PatientResponse findById(long patientId);

    PatientResponse save(Patient patient);

    PatientResponse update(long patientId,Patient patient);

    PatientResponse delete(long patientId);







}
