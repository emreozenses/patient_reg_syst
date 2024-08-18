package com.tiga.patient_reg_syst.service;

import com.tiga.patient_reg_syst.dto.AddressResponse;
import com.tiga.patient_reg_syst.dto.PatientResponse;
import com.tiga.patient_reg_syst.entity.Address;
import com.tiga.patient_reg_syst.entity.Patient;

import java.util.List;

public interface AddressService {

    List<AddressResponse> findAll();

    AddressResponse findById(long id);

    AddressResponse save(Address address);

    AddressResponse update(long id,Address address);

    AddressResponse delete(long id);
}
