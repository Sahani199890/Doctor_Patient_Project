package com.example.DoctorAndPatient.controller;

import com.example.DoctorAndPatient.dao.IDoctorRepo;
import com.example.DoctorAndPatient.model.DoctorModel;
import com.example.DoctorAndPatient.service.DoctorService;
import com.example.DoctorAndPatient.utils.Util;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private IDoctorRepo iDoctorRepo;
    @PostMapping("/add-doctor")
    public ResponseEntity<String> addDoctor(@RequestBody DoctorModel doctorModel) {
        JSONObject valid = isValid(doctorModel);
        if(valid.isEmpty()){
            doctorService.addDoctor(doctorModel);
            return new ResponseEntity<>("Doctor is added successfully with Id -> "+doctorModel.getDoctorId(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(valid.toString(),HttpStatus.BAD_REQUEST);
    }
    private JSONObject isValid(DoctorModel doctorModel){
        JSONObject json=new JSONObject();
        if(!Util.city(doctorModel.getDoctorCity())){
            json.append(doctorModel.getDoctorCity(),"Doctor's should be from delhi or noida or faridabad");
        }
        if(!doctorModel.getDoctorSpeciality().equals("Orthopedic") && !doctorModel.getDoctorSpeciality().equals("Dermatologist") && !doctorModel.getDoctorSpeciality().equals("Gynecologist") && !doctorModel.getDoctorSpeciality().equals("ENT")){
            json.append(doctorModel.getDoctorSpeciality(),"Doctor's either be specialized in Orthopedic or ENT or Gynecology or Dermatology");
        }
        return json;
    }
    @DeleteMapping("delete-doctor-by-Id/{doctorId}")
    public ResponseEntity<String> deleteDoctor(@PathVariable int doctorId){
        if(iDoctorRepo.findById(doctorId).isPresent()){
            doctorService.deleteDoctor(doctorId);
            return new ResponseEntity<>("Doctor deleted successfully with Id-> "+doctorId,HttpStatus.OK);
        }
        return new ResponseEntity<>("Doctor with given id is not present in database",HttpStatus.BAD_REQUEST);

    }
}
