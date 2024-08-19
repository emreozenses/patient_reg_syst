package com.tiga.patient_reg_syst.dto;

import com.tiga.patient_reg_syst.entity.Address;
import com.tiga.patient_reg_syst.entity.Gender;
import com.tiga.patient_reg_syst.entity.Notification;

import java.time.LocalDate;

public record PatientQueryResponse(Long patientId, String firstName, String midName, String surname, Gender gender, LocalDate birthDate, String email, String cellPhone,String address) {
}
