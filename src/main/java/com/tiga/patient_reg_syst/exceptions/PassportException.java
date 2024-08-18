package com.tiga.patient_reg_syst.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PassportException extends RuntimeException{

    private HttpStatus httpStatus;

    public PassportException(String message,HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
}