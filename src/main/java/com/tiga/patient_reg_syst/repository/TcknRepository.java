package com.tiga.patient_reg_syst.repository;

import com.tiga.patient_reg_syst.entity.Tckn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TcknRepository extends JpaRepository<Tckn,Long> {
}
