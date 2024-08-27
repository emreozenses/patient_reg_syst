package com.tiga.patient_reg_syst.patient.service;

import com.tiga.patient_reg_syst.patient.converter.DtoConverter;
import com.tiga.patient_reg_syst.patient.dto.PatientQueryResponse;
import com.tiga.patient_reg_syst.patient.dto.PatientResponse;
import com.tiga.patient_reg_syst.patient.entity.Patient;

import java.util.List;

public interface PatientService{

    List<PatientResponse> findAll();

    PatientResponse findById(long patientId);

    PatientResponse save(Patient patient);

    PatientResponse update(long patientId,Patient patient);

    PatientResponse delete(long patientId);

    List <PatientQueryResponse> findByName(String name);

    List<PatientQueryResponse> findBySurname(String surname);

    List<PatientQueryResponse> filterByGender(String gender);
    List<PatientQueryResponse> filterByAge(Integer age);

    List<PatientQueryResponse> orderByBirthDateAsc();

    List<PatientQueryResponse> orderByAge();

    void deleteDuplicatePatient();




}
