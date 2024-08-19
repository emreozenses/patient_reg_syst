package com.tiga.patient_reg_syst.converter;

import com.tiga.patient_reg_syst.dto.PatientQueryResponse;
import com.tiga.patient_reg_syst.dto.PatientResponse;
import com.tiga.patient_reg_syst.entity.Address;
import com.tiga.patient_reg_syst.entity.Passport;
import com.tiga.patient_reg_syst.entity.Patient;
import com.tiga.patient_reg_syst.entity.Tckn;

import java.util.ArrayList;
import java.util.List;

public class DtoConverter {

    public static PatientResponse convertToPatientResponse(Patient patient){
        return new PatientResponse(patient.getPatientId(),patient.getTckn().getTckn(),patient.getPassport().getPassportNumber(), patient.getFirstName(), patient.getMidName(), patient.getSurname(),patient.getGender(),patient.getBirthDate(), patient.getEmail(), patient.getCellPhone(), patient.getLandlinePhone(), patient.getNotificationPreferences(),patient.getAddress().getDescription());
    }

    public static List<PatientResponse> convertToPatientResponseList (List<Patient> patients){
        List<PatientResponse> patientResponseList = new ArrayList<>();
        patients.forEach(patient -> {
            patientResponseList.add(convertToPatientResponse(patient));
        });
        return patientResponseList;
    }

    public static PatientQueryResponse convertToPatientQueryResponse(Patient patient){
        return new PatientQueryResponse(patient.getPatientId(), patient.getFirstName(), patient.getMidName(), patient.getSurname(),patient.getGender(),patient.getBirthDate(), patient.getEmail(), patient.getCellPhone(),patient.getAddress().getDescription());
    }

    public static List<PatientQueryResponse> convertToPatientQueryResponseList (List<Patient> patients){
        List<PatientQueryResponse> patientQueryResponseList = new ArrayList<>();
        patients.forEach(patient -> {
            patientQueryResponseList.add(convertToPatientQueryResponse(patient));
        });
        return patientQueryResponseList;
    }



}
