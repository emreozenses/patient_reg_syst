package com.tiga.patient_reg_syst.dto;

import com.tiga.patient_reg_syst.entity.*;

import java.time.LocalDate;

public record PatientResponse(Long patientId, String tckn, String passportNumber, String firstName, String midName, String surname, Gender gender, LocalDate birthDate, String email, String cellPhone, String landlinePhone,
                              Notification notificationPreferences, String address) {
}
