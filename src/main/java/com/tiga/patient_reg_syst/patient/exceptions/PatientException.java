package com.tiga.patient_reg_syst.patient.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PatientException extends RuntimeException{

    private HttpStatus httpStatus;

    public PatientException(String message,HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
}
