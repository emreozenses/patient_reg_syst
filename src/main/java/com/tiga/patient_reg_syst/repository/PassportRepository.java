package com.tiga.patient_reg_syst.repository;

import com.tiga.patient_reg_syst.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport,Long> {
}
