package com.tiga.patient_reg_syst.dto;

import com.tiga.patient_reg_syst.entity.Gender;

import java.time.LocalDate;

public record PatientWithAgeQueryResponse(Long patientId, String firstName, String midName, String surname, Gender gender,Double age,
                                          LocalDate birthDate, String email, String cellPhone, String address) {
}
