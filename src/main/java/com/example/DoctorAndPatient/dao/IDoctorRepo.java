package com.example.DoctorAndPatient.dao;

import com.example.DoctorAndPatient.model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IDoctorRepo extends JpaRepository<DoctorModel,Integer> {
    @Query(value = "Select * from doctor_tbl where doctor_city=:city",nativeQuery = true)
    public List<DoctorModel> findByDoctorCity(String city);
    @Query(value = "Select * from doctor_tbl where doctor_specialized=:symptom and doctor_city=:city",nativeQuery = true)
    public List<DoctorModel> findByDoctorSpecializedInAndDoctorCity(String city,String symptom);
}
