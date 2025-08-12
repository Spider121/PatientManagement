package com.Maccess.patientService.controller;

import com.Maccess.patientService.dto.PatientResponseDto;
import com.Maccess.patientService.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/getPatients")
    public List<PatientResponseDto> getAllPatients(){
      return  patientService.getPatients();
    }
}
