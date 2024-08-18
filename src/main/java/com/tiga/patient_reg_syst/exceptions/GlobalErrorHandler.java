package com.tiga.patient_reg_syst.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler
    public ResponseEntity<PatientErrorResponse> patientErrorResponseResponseEntity (PatientException patientException){

        PatientErrorResponse patientErrorResponse = new PatientErrorResponse(patientException.getMessage(),patientException.getHttpStatus().value(), LocalDateTime.now());
        log.error("PatientException occured!",patientErrorResponse.toString());
        return new ResponseEntity<>(patientErrorResponse,patientException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<AddressErrorResponse> addressErrorResponseResponseEntity (AddressException addressException){

        AddressErrorResponse addressErrorResponse = new AddressErrorResponse(addressException.getMessage(),addressException.getHttpStatus().value(), LocalDateTime.now());
        log.error("AddressException occured!",addressErrorResponse.toString());
        return new ResponseEntity<>(addressErrorResponse,addressException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<PassportErrorResponse> passportErrorResponseResponseEntity (PassportException passportException){

        PassportErrorResponse passportErrorResponse = new PassportErrorResponse(passportException.getMessage(),passportException.getHttpStatus().value(), LocalDateTime.now());
        log.error("PassportException occured!",passportErrorResponse.toString());
        return new ResponseEntity<>(passportErrorResponse,passportException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<TcknErrorResponse> tcknErrorResponseResponseEntity (TcknException tcknException){

        TcknErrorResponse tcknErrorResponse = new TcknErrorResponse(tcknException.getMessage(),tcknException.getHttpStatus().value(), LocalDateTime.now());
        log.error("TcknException occured!",tcknErrorResponse.toString());
        return new ResponseEntity<>(tcknErrorResponse,tcknException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<GlobalErrorResponse> exceptionHandler (Exception exception){

        GlobalErrorResponse globalErrorResponse = new GlobalErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
        log.error("Exception occured", exception.toString());
        return new ResponseEntity<>(globalErrorResponse, HttpStatusCode.valueOf(globalErrorResponse.getStatus()));
    }

    @ExceptionHandler
    public ResponseEntity handleException(MethodArgumentNotValidException exception){
        List errorList = exception.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> {
                    Map<String,String> errorMap = new HashMap<>();
                    errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                    return errorMap;
                }).collect(Collectors.toList());
        log.error("MethodArgumentNotValidException occured!",exception.getMessage());
        return new ResponseEntity(errorList,HttpStatus.BAD_REQUEST);
    }

}
