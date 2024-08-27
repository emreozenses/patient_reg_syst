package com.tiga.patient_reg_syst.patient.dto;


import com.tiga.patient_reg_syst.patient.entity.Gender;
import com.tiga.patient_reg_syst.patient.entity.Notification;

import java.time.LocalDate;

public record PatientResponse(Long patientId, String tckn, String passportNumber, String firstName, String midName, String surname, Gender gender,
                              LocalDate birthDate, Integer age, String email, String cellPhone, String landlinePhone,
                              Notification notificationPreferences, String address) {
}
