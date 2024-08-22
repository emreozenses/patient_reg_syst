package com.tiga.patient_reg_syst.repository;

import com.tiga.patient_reg_syst.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    @Query(value = "SELECT * FROM public.patients AS p WHERE p.first_name ILIKE :name%",nativeQuery = true)
    List<Patient> findByName(String name);

    @Query(value = "SELECT * FROM public.patients AS p WHERE p.surname ILIKE :surname%",nativeQuery = true)
    List<Patient> findBySurname(String surname);

    @Query(value = "SELECT * FROM public.patients AS p WHERE p.gender ILIKE :gender% ORDER BY p.first_name ASC",nativeQuery = true)
    List<Patient> filterByGender(String gender);
    @Query(value = "SELECT * FROM public.patients AS p ORDER BY p.birth_date ASC ",nativeQuery = true)
    List<Patient> orderByBirthDateAsc();

    @Query(value = "SELECT * FROM public.patients AS p ORDER BY p.age ASC",nativeQuery = true)
    List<Patient> orderByAge();




}
