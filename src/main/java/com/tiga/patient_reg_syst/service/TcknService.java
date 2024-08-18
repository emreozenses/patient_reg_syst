package com.tiga.patient_reg_syst.service;

import com.tiga.patient_reg_syst.dto.PatientResponse;
import com.tiga.patient_reg_syst.dto.TcknResponse;
import com.tiga.patient_reg_syst.entity.Patient;
import com.tiga.patient_reg_syst.entity.Tckn;

import java.util.List;

public interface TcknService {

    List<TcknResponse> findAll();

    TcknResponse findById(long id);

    TcknResponse save(Tckn tckn);

    TcknResponse update(long id,Tckn tckn);

    TcknResponse delete(long id);
}
