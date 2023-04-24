package com.example.DoctorAndPatient.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients_tbl")
public class PatientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    @Length(min = 3,message = "patientName should be minimum of 3 Characters")
    private String patientName;
    @Length(max = 20,message = "City name should be under 20 Characters")
    @Column(name = "patient_city")
    private String city;
    @Email(message = "PLease provide valid mail")
    private String email;
    @Length(min=10,max = 10,message = "phone number length should be of 10 digits only")
    private String phoneNumber;
    @Column(name = "patient_symptom")
    private String symptom;
}
