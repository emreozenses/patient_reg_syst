package com.tiga.patient_reg_syst.service;

import com.tiga.patient_reg_syst.dto.PassportResponse;
import com.tiga.patient_reg_syst.dto.TcknResponse;
import com.tiga.patient_reg_syst.entity.Passport;
import com.tiga.patient_reg_syst.entity.Tckn;

import java.util.List;

public interface PassportService {

    List<PassportResponse> findAll();

    PassportResponse findById(long id);

    PassportResponse save(Passport passport);

    PassportResponse update(long id,Passport passport);

    PassportResponse delete(long id);
}
