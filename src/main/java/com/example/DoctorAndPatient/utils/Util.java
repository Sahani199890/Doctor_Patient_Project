package com.example.DoctorAndPatient.utils;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<String> cityList=new ArrayList<>();
    public static boolean city(String city){
        cityList.add("delhi");
        cityList.add("faridabad");
        cityList.add("noida");
        return cityList.contains(city);
    }


    public static String citytoString() {
        String ans=" ";
        for(String city:cityList){
            ans+=city+"🚑";
        }
        return ans.trim();
    }

    public static String symptom(String symptom){
        String ans = switch (symptom) {
            case "arthritis", "back pain", "tissue injuries" -> "Orthopedic";
            case "dysmenorrhea" -> "Gynecology";
            case "skin burn", "skin infection" -> "Dermatology";
            case "ear pain" -> "ENT";
            default -> "";
        };
        return ans;
    }
}