package com.tiga.patient_reg_syst.service;

import com.tiga.patient_reg_syst.converter.DtoConverter;
import com.tiga.patient_reg_syst.dto.PassportResponse;
import com.tiga.patient_reg_syst.dto.TcknResponse;
import com.tiga.patient_reg_syst.entity.Passport;
import com.tiga.patient_reg_syst.entity.Patient;
import com.tiga.patient_reg_syst.entity.Tckn;
import com.tiga.patient_reg_syst.exceptions.PassportException;
import com.tiga.patient_reg_syst.exceptions.PatientException;
import com.tiga.patient_reg_syst.exceptions.TcknException;
import com.tiga.patient_reg_syst.repository.TcknRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TcknServiceImpl implements TcknService{

    private final TcknRepository tcknRepository;

    @Autowired
    public TcknServiceImpl(TcknRepository tcknRepository) {
        this.tcknRepository = tcknRepository;
    }

    @Override
    public List<TcknResponse> findAll() {
        List<Tckn> foundTcknList = tcknRepository.findAll();
        return DtoConverter.convertToTcknResponseList(foundTcknList);
    }

    @Override
    public TcknResponse findById(long id) {
        Optional<Tckn> foundTckn = tcknRepository.findById(id);
        if(foundTckn.isPresent()) {
            return DtoConverter.convertToTcknResponse(foundTckn.get());
        }
        throw new TcknException("Tckn with given id is not found: "+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public TcknResponse save(Tckn tckn) {
        return DtoConverter.convertToTcknResponse(tcknRepository.save(tckn));
    }

    @Override
    public TcknResponse update(long id, Tckn tckn) {
        Optional<Tckn> foundTckn = tcknRepository.findById(id);
        if(foundTckn.isPresent()){
            foundTckn.get().setTckn(tckn.getTckn());
            tcknRepository.save(foundTckn.get());
            return DtoConverter.convertToTcknResponse(foundTckn.get());
        }
        throw new TcknException("Given id is not exist: "+id,HttpStatus.NOT_FOUND);
    }

    @Override
    public TcknResponse delete(long id) {
        TcknResponse willRemove = findById(id);
        tcknRepository.deleteById(id);
        return willRemove;
    }
}
