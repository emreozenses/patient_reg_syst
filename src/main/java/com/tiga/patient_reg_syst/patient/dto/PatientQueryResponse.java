package com.tiga.patient_reg_syst.patient.dto;

import com.tiga.patient_reg_syst.patient.entity.Gender;

import java.time.LocalDate;

public record PatientQueryResponse(Long patientId, String firstName, String midName, String surname, Gender gender,
                                    LocalDate birthDate,Integer age ,String email, String cellPhone, String address) {
}
