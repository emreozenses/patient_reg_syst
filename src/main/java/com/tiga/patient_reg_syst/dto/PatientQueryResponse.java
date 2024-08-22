package com.tiga.patient_reg_syst.dto;

import com.tiga.patient_reg_syst.entity.Address;
import com.tiga.patient_reg_syst.entity.Gender;
import com.tiga.patient_reg_syst.entity.Notification;
import org.antlr.v4.runtime.misc.Interval;

import java.time.LocalDate;

public record PatientQueryResponse(Long patientId, String firstName, String midName, String surname, Gender gender,
                                    LocalDate birthDate,Integer age ,String email, String cellPhone, String address) {
}
