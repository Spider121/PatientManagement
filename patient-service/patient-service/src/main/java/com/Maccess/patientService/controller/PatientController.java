package com.Maccess.patientService.controller;

import com.Maccess.patientService.dto.PatientRequestDto;
import com.Maccess.patientService.dto.PatientResponseDto;
import com.Maccess.patientService.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@Tag(name = "Patient",description = "API for managing Patients")
@CrossOrigin(origins = "*")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/getPatients")
    @Operation(summary = "Get All Patients")
    public ResponseEntity<List<PatientResponseDto>> getAllPatients(){
      return ResponseEntity.ok().body( patientService.getPatients());
    }

    @PostMapping("/createPatient")
    @Operation(summary = "Create A new Patient")
    public ResponseEntity<PatientResponseDto> createPatient(@Valid @RequestBody PatientRequestDto patientRequestDto){
        PatientResponseDto patientResponseDto = patientService.createPatient(patientRequestDto);
        return ResponseEntity.ok().body(patientResponseDto);
    }

    @PutMapping("/updatePatient/{id}")
    @Operation(summary = "Update A Patient")
    public ResponseEntity<PatientResponseDto> updatePatient(@PathVariable Long id ,@Validated({Default.class}) @RequestBody PatientRequestDto patientRequestDto){
       return ResponseEntity.ok().body(patientService.updatePatient(id,patientRequestDto));
    }

    @DeleteMapping("/deletePatient/{id}")
    @Operation(summary = "Delete A Patient")
    public ResponseEntity<String> deleteResponse(@PathVariable Long id){
        String message = patientService.deletePatient(id);
        return ResponseEntity.ok().body(message);
    }
}
