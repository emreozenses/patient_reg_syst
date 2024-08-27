package com.tiga.patient_reg_syst.patient.repository;

import com.tiga.patient_reg_syst.patient.dto.PatientQueryResponse;
import com.tiga.patient_reg_syst.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query(value = "SELECT * FROM public.patients AS p WHERE p.first_name ILIKE :name%",nativeQuery = true)
    List<Patient> findByName(String name);

    @Query(value = "SELECT * FROM public.patients AS p WHERE p.surname ILIKE :surname%",nativeQuery = true)
    List<Patient> findBySurname(String surname);

    @Query(value = "SELECT * FROM public.patients AS p WHERE p.gender ILIKE :gender% ORDER BY p.first_name ASC",nativeQuery = true)
    List<Patient> filterByGender(String gender);
    @Query(value = "SELECT * FROM public.patients AS p WHERE p.age > :age ORDER BY p.age ASC",nativeQuery = true)
    List<Patient> filterByAge(Integer age);
    @Query(value = "SELECT * FROM public.patients AS p ORDER BY p.birth_date ASC ",nativeQuery = true)
    List<Patient> orderByBirthDateAsc();

    @Query(value = "SELECT * FROM public.patients AS p ORDER BY p.age ASC",nativeQuery = true)
    List<Patient> orderByAge();

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM patients WHERE patient_id IN (SELECT patient_id FROM (SELECT patient_id,ROW_NUMBER() OVER(PARTITION BY first_name,surname,birth_date ORDER BY patient_id) AS row_num FROM patients) t WHERE t.row_num>1) ",nativeQuery = true)
    void deleteDuplicatePatient();




}
