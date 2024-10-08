package com.tiga.patient_reg_syst.patient.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="address",schema = "public")
public class Address {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH},mappedBy = "address")
    private List<Patient> patientList;

    public void addPatient(Patient patient){
        if(patientList == null){
            patientList = new ArrayList<>();
        }
        patientList.add(patient);
    }

}
