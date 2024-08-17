package com.tiga.patient_reg_syst.repository;

import com.tiga.patient_reg_syst.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
