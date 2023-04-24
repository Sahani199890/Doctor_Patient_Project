package com.example.DoctorAndPatient.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor_tbl")
public class DoctorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;
    private String doctorName;
    @Column(name = "doctor_city")
    private String doctorCity;
    private String doctorEmail;
    private String doctorPhoneNumber;
    @Column(name = "doctor_specialized")
    private String doctorSpeciality;
}
