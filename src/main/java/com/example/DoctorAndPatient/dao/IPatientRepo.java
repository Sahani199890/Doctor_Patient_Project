package com.example.DoctorAndPatient.dao;

import com.example.DoctorAndPatient.model.DoctorModel;
import com.example.DoctorAndPatient.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPatientRepo extends JpaRepository<PatientModel,Integer> {
}
