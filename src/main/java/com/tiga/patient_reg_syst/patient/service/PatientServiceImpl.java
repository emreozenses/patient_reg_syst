package com.tiga.patient_reg_syst.patient.service;

import com.tiga.patient_reg_syst.patient.converter.DtoConverter;
import com.tiga.patient_reg_syst.patient.dto.PatientQueryResponse;
import com.tiga.patient_reg_syst.patient.dto.PatientResponse;
import com.tiga.patient_reg_syst.patient.entity.Patient;
import com.tiga.patient_reg_syst.patient.exceptions.PatientException;
import com.tiga.patient_reg_syst.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {


    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {

        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientResponse> findAll() {
        List<Patient> foundPatientList = patientRepository.findAll();
        return DtoConverter.convertToPatientResponseList(foundPatientList);
    }

    @Override
    public PatientResponse findById(long patientId) {
        Optional<Patient> foundPatient = patientRepository.findById(patientId);
        if(foundPatient.isPresent()) {
            return DtoConverter.convertToPatientResponse(foundPatient.get());
        }
        throw new PatientException("Patient with given id is not found: "+patientId, HttpStatus.NOT_FOUND);
    }


    @Override
    public PatientResponse save(Patient patient) {


        LocalDate birthDate = patient.getBirthDate();
        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(birthDate, currentDate);
        Integer calculatedAge = period.getYears();
        patient.setAge(calculatedAge);

        return DtoConverter.convertToPatientResponse(patientRepository.save(patient));
    }

    @Override
    public PatientResponse update(long patientId, Patient patient) {
        Optional<Patient> foundPatient = patientRepository.findById(patientId);
        if(foundPatient.isPresent()){
            foundPatient.get().getTckn().setTckn(patient.getTckn().getTckn());
            foundPatient.get().getPassport().setPassportNumber(patient.getPassport().getPassportNumber());
            foundPatient.get().setFirstName(patient.getFirstName());
            foundPatient.get().setMidName(patient.getMidName());
            foundPatient.get().setSurname(patient.getSurname());
            foundPatient.get().setBirthDate(patient.getBirthDate());
            foundPatient.get().setGender(patient.getGender());
            foundPatient.get().setEmail(patient.getEmail());
            foundPatient.get().setCellPhone(patient.getCellPhone());
            foundPatient.get().setLandlinePhone(patient.getLandlinePhone());
            foundPatient.get().getAddress().setDescription(patient.getAddress().getDescription());
            foundPatient.get().setNotificationPreferences(patient.getNotificationPreferences());

            LocalDate birthDate = foundPatient.get().getBirthDate();
            LocalDate currentDate = LocalDate.now();

            Period period = Period.between(birthDate, currentDate);
            Integer calculatedAge = period.getYears();
            foundPatient.get().setAge(calculatedAge);

            patientRepository.save(foundPatient.get());
            return DtoConverter.convertToPatientResponse(foundPatient.get());
        }
        throw new PatientException("Given id is not exist: "+patientId,HttpStatus.NOT_FOUND);
    }

    @Override
    public PatientResponse delete(long patientId) {
        PatientResponse willRemove = findById(patientId);
        patientRepository.deleteById(patientId);
        return willRemove;
    }

    @Override
    public List<PatientQueryResponse> findByName(String name) {
        return DtoConverter.convertToPatientQueryResponseList(patientRepository.findByName(name));
    }

    @Override
    public List<PatientQueryResponse> findBySurname(String surname) {
        return DtoConverter.convertToPatientQueryResponseList(patientRepository.findBySurname(surname));
    }

    @Override
    public List<PatientQueryResponse> filterByGender(String gender) {
        return DtoConverter.convertToPatientQueryResponseList(patientRepository.filterByGender(gender));
    }
    @Override
    public List<PatientQueryResponse> filterByAge(Integer age) {
        return DtoConverter.convertToPatientQueryResponseList(patientRepository.filterByAge(age));
    }

    @Override
    public List<PatientQueryResponse> orderByBirthDateAsc() {
        return DtoConverter.convertToPatientQueryResponseList(patientRepository.orderByBirthDateAsc());
    }

    @Override
    public List<PatientQueryResponse> orderByAge() {
        return DtoConverter.convertToPatientQueryResponseList(patientRepository.orderByAge());
    }

    @Override
    public void deleteDuplicatePatient() {
        patientRepository.deleteDuplicatePatient();
    }


}
