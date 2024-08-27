package com.tiga.patient_reg_syst.patient.controller;

import com.tiga.patient_reg_syst.patient.dto.RegisterResponse;
import com.tiga.patient_reg_syst.patient.dto.RegistrationMember;
import com.tiga.patient_reg_syst.patient.entity.Member;
import com.tiga.patient_reg_syst.patient.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationService authenticationService;


    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/register")
    public RegisterResponse register (@RequestBody RegistrationMember registrationMember){

        Member registeredMember = authenticationService.register(registrationMember.email(), registrationMember.password());

        return new RegisterResponse(registeredMember.getEmail(), "Account created successfully");

    }
}
