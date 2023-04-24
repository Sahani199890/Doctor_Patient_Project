package com.example.DoctorAndPatient.controller;

import com.example.DoctorAndPatient.dao.IDoctorRepo;
import com.example.DoctorAndPatient.dao.IPatientRepo;
import com.example.DoctorAndPatient.model.DoctorModel;
import com.example.DoctorAndPatient.model.PatientModel;
import com.example.DoctorAndPatient.service.PatientService;
import com.example.DoctorAndPatient.utils.Util;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private IPatientRepo iPatientRepo;

    @PostMapping("/add-patient")
    public ResponseEntity<String> addPatient(@Valid @RequestBody PatientModel patientModel) {
        var valid = isValid(patientModel);
        if (valid==null) {
            patientService.addPatient(patientModel);
            return new ResponseEntity<>("Patient added Successfully with Id->"+patientModel.getPatientId(), HttpStatus.CREATED);
        }return new ResponseEntity<>(valid.toString(),HttpStatus.BAD_REQUEST);
    }

    private String isValid(PatientModel patientModel) {
        if(!Util.city(patientModel.getCity())){
            return "We are still waiting to expand to your location so please choose location from-> "+Util.citytoString();
        }
        return null;
    }

    @GetMapping("/get-suggested-doctors/{patientId}")
    public ResponseEntity<String> getSuggestedDoctor(@PathVariable Integer patientId) {
        String suggestedDoctor = patientService.getSuggestedDoctor(patientId);
        if(suggestedDoctor.contains("Sorry")){
            return new ResponseEntity<>(suggestedDoctor, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(suggestedDoctor,HttpStatus.FOUND);
    }
    @DeleteMapping("delete-patient-by-id/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable int patientId){
        if(iPatientRepo.findById(patientId).isPresent()){
            patientService.deletePatient(patientId);
            return new ResponseEntity<>("Patient deleted successfully with Id->"+patientId,HttpStatus.OK);
        }
        return new ResponseEntity<>("Patient with given id is not present in database",HttpStatus.BAD_REQUEST);
    }

}
