package com.tiga.patient_reg_syst.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="passport",schema = "public")
public class Passport {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;


    @Column(name = "passport_number")
    private String passportNumber;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
            mappedBy = "passport")
    private Patient patient;

   /* public void addPatient(Patient patient){
        if(patientList == null){
            patientList = new ArrayList<>();
        }
        patientList.add(patient);
    }*/
}
