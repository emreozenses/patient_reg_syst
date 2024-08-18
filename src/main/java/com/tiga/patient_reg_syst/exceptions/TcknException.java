package com.tiga.patient_reg_syst.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TcknException extends RuntimeException{

    private HttpStatus httpStatus;

    public TcknException(String message,HttpStatus httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
}