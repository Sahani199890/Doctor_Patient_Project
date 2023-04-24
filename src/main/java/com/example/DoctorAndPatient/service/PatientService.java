package com.example.DoctorAndPatient.service;

import com.example.DoctorAndPatient.dao.IDoctorRepo;
import com.example.DoctorAndPatient.dao.IPatientRepo;
import com.example.DoctorAndPatient.model.DoctorModel;
import com.example.DoctorAndPatient.model.PatientModel;
import com.example.DoctorAndPatient.utils.Util;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientService {
    @Autowired
    private IPatientRepo iPatientRepo;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private IDoctorRepo iDoctorRepo;

    public void addPatient(PatientModel patientModel) {
        iPatientRepo.save(patientModel);
    }

    public String getSuggestedDoctor(Integer patientId) {
        if(iPatientRepo.findById(patientId).isEmpty()){
            return "Sorry patient with the Id "+patientId+" is not present in the database";
        }
        PatientModel patientModel = iPatientRepo.findById(patientId).get();
        String symptom = Util.symptom(patientModel.getSymptom());
        if(!Util.city(patientModel.getCity())){
            return "Sorry, We are still waiting to expand to your location";
        }

        if(iDoctorRepo.findByDoctorCity(patientModel.getCity()).isEmpty()){
            return "Sorry, We are still waiting to expand to your location";
        }
        List<DoctorModel> byDoctorSpecializedInAndDoctorCity = iDoctorRepo.findByDoctorSpecializedInAndDoctorCity(patientModel.getCity().toUpperCase(), symptom);
        JSONArray jArray=new JSONArray();
        for(DoctorModel val:byDoctorSpecializedInAndDoctorCity){
            jArray.put(val);
        }
        if(jArray.length()==0){
            return "Sorry, There isn’t any doctor present at your location for your symptom";
        }
        return jArray.toString();
    }

    public void deletePatient(int patientId) {
        iPatientRepo.deleteById(patientId);
    }
}
