package com.tiga.patient_reg_syst.service;

import com.tiga.patient_reg_syst.converter.DtoConverter;
import com.tiga.patient_reg_syst.dto.AddressResponse;
import com.tiga.patient_reg_syst.dto.PassportResponse;
import com.tiga.patient_reg_syst.entity.Address;
import com.tiga.patient_reg_syst.entity.Passport;
import com.tiga.patient_reg_syst.exceptions.AddressException;
import com.tiga.patient_reg_syst.exceptions.PassportException;
import com.tiga.patient_reg_syst.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassportServiceImpl implements PassportService{

    private final PassportRepository passportRepository;

    @Autowired
    public PassportServiceImpl(PassportRepository passportRepository) {
        this.passportRepository = passportRepository;
    }

    @Override
    public List<PassportResponse> findAll() {
        List<Passport> foundPassportList = passportRepository.findAll();
        return DtoConverter.convertToPassportResponseList(foundPassportList);
    }

    @Override
    public PassportResponse findById(long id) {
        Optional<Passport> foundPassport = passportRepository.findById(id);
        if(foundPassport.isPresent()) {
            return DtoConverter.convertToPassportResponse(foundPassport.get());
        }
        throw new PassportException("Passport with given id not found: "+id, HttpStatus.NOT_FOUND);
    }


    @Override
    public PassportResponse save(Passport passport) {
        return DtoConverter.convertToPassportResponse(passportRepository.save(passport));
    }

    @Override
    public PassportResponse update(long id, Passport passport) {
        Optional<Passport> foundPassport = passportRepository.findById(id);
        if(foundPassport.isPresent()){
            foundPassport.get().setPassportNumber(passport.getPassportNumber());
            passportRepository.save(foundPassport.get());
            return DtoConverter.convertToPassportResponse(foundPassport.get());
        }
        throw new PassportException("Given id is not exist: "+id,HttpStatus.NOT_FOUND);
    }

    @Override
    public PassportResponse delete(long id) {
        PassportResponse willRemove = findById(id);
        passportRepository.deleteById(id);
        return willRemove;
    }
}
