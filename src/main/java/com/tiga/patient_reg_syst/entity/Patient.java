package com.tiga.patient_reg_syst.entity;


import io.hypersistence.utils.hibernate.type.interval.PostgreSQLIntervalType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.Interval;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;
import org.springframework.data.repository.cdi.Eager;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="patients",schema = "public")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private long patientId;

    @Column(name = "first_name")
    @NotNull
    @Size(min = 2, max = 50, message = "Input character length must be min.2 ,max.50")
    private String firstName;

    @Column(name = "mid_name")
    private String midName;

    @Column(name = "surname")
    @NotNull
    @Size(min = 2, max = 50, message = "Input character length must be min.2 ,max.50")
    private String surname;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "gender")
    private Gender gender;

    @NotNull
    @Column(name = "birth_date")
    private LocalDate birthDate;


    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    @Size(min = 6, max = 50, message = "Input character length must be min.2 ,max.50")
    private String email;

    @Column(name = "cell_phone")
    @Size(min = 10, max = 15, message = "Input character length must be min.2 ,max.50")
    private String cellPhone;

    @Column(name = "landline_phone")
    private String landlinePhone;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "notification_preferences")
    private Notification notificationPreferences;



    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "tckn_id")
    private Tckn tckn;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "passport_number_id")
    private Passport passport;



    public Integer calculateAge(LocalDate birthDate, LocalDate currentDate) {
        // Calculate period between birthdate and current date
        Period period = Period.between(birthDate, LocalDate.now());
        Integer calculatedAge = period.getYears();
        setAge(calculatedAge);
        return age;
    }

}
