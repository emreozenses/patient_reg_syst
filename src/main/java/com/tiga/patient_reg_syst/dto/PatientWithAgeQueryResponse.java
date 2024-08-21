package com.tiga.patient_reg_syst.dto;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.tiga.patient_reg_syst.entity.Gender;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public record PatientWithAgeQueryResponse(Long patientId, String firstName, String midName, String surname, Gender gender,
                                          Duration age,
                                          LocalDate birthDate, String email, String cellPhone, String address) {
}
