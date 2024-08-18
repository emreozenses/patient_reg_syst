package com.tiga.patient_reg_syst.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressErrorResponse {

    private String message;
    private Integer status;
    private LocalDateTime errorTime;
}
