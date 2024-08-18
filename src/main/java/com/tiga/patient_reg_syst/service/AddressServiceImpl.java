package com.tiga.patient_reg_syst.service;

import com.tiga.patient_reg_syst.converter.DtoConverter;
import com.tiga.patient_reg_syst.dto.AddressResponse;
import com.tiga.patient_reg_syst.dto.PatientResponse;
import com.tiga.patient_reg_syst.entity.Address;
import com.tiga.patient_reg_syst.entity.Patient;
import com.tiga.patient_reg_syst.exceptions.AddressException;
import com.tiga.patient_reg_syst.exceptions.PatientException;
import com.tiga.patient_reg_syst.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public List<AddressResponse> findAll() {
        List<Address> foundAddressList = addressRepository.findAll();
        return DtoConverter.convertToAddressResponseList(foundAddressList);
    }

    @Override
    public AddressResponse findById(long id) {
        Optional<Address> foundAddress = addressRepository.findById(id);
        if(foundAddress.isPresent()) {
            return DtoConverter.convertToAddressResponse(foundAddress.get());
        }
        throw new AddressException("Address with given id is not found: "+id, HttpStatus.NOT_FOUND);
    }


    @Override
    public AddressResponse save(Address address) {
        return DtoConverter.convertToAddressResponse(addressRepository.save(address));
    }

    @Override
    public AddressResponse update(long id, Address address) {
        Optional<Address> foundAddress = addressRepository.findById(id);
        if(foundAddress.isPresent()){
            foundAddress.get().setDescription(address.getDescription());
            addressRepository.save(foundAddress.get());
            return DtoConverter.convertToAddressResponse(foundAddress.get());
        }
        throw new AddressException("Given id is not exist: "+id,HttpStatus.NOT_FOUND);
    }

    @Override
    public AddressResponse delete(long id) {
        AddressResponse willRemove = findById(id);
        addressRepository.deleteById(id);
        return willRemove;
    }
}
