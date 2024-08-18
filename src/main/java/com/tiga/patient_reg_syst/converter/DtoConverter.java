package com.tiga.patient_reg_syst.converter;

import com.tiga.patient_reg_syst.dto.AddressResponse;
import com.tiga.patient_reg_syst.dto.PassportResponse;
import com.tiga.patient_reg_syst.dto.PatientResponse;
import com.tiga.patient_reg_syst.dto.TcknResponse;
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

    public static AddressResponse convertToAddressResponse (Address address){
        return new AddressResponse(address.getDescription());
    }

    public static List<AddressResponse> convertToAddressResponseList (List<Address> addresses){
        List<AddressResponse> addressResponseList = new ArrayList<>();
        addresses.forEach(address -> {
            addressResponseList.add(convertToAddressResponse(address));
        });
        return addressResponseList;
    }


    public static PassportResponse convertToPassportResponse (Passport passport){
        return new PassportResponse(passport.getPassportNumber());
    }

    public static List<PassportResponse> convertToPassportResponseList (List<Passport> passports){
        List<PassportResponse> passportResponseList = new ArrayList<>();
        passports.forEach(passport -> {
            passportResponseList.add(convertToPassportResponse(passport));
        });
        return passportResponseList;
    }

    public static TcknResponse convertToTcknResponse (Tckn tckn){
        return new TcknResponse(tckn.getTckn());
    }
    public static List<TcknResponse> convertToTcknResponseList (List<Tckn> tckns){
        List<TcknResponse> tcknResponseList = new ArrayList<>();
        tckns.forEach(tckn -> {
            tcknResponseList.add(convertToTcknResponse(tckn));
        });
        return tcknResponseList;
    }

}
