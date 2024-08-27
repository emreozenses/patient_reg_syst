package com.tiga.patient_reg_syst.patient.repository;

import com.tiga.patient_reg_syst.patient.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository <Roles,Long>{

    @Query("SELECT r FROM Roles r WHERE r.authority=:authority")
    Optional<Roles> findByAuthority(String authority);


}
