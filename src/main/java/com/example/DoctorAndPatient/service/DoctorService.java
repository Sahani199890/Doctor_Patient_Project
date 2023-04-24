package com.example.DoctorAndPatient.service;

import com.example.DoctorAndPatient.dao.IDoctorRepo;
import com.example.DoctorAndPatient.model.DoctorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DoctorService {
    @Autowired
    private IDoctorRepo iDoctorRepo;
   public Map<String,List<DoctorModel>> doctorsMap=new HashMap<>();
    public void addDoctor(DoctorModel doctorModel) {
        iDoctorRepo.save(doctorModel);
    }

    public void deleteDoctor(int doctorId) {
        iDoctorRepo.deleteById(doctorId);
    }
}
