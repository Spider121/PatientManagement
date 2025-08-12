package com.Maccess.patientService.service;

import com.Maccess.patientService.Mapper.PatientMapper;
import com.Maccess.patientService.dto.PatientResponseDto;
import com.Maccess.patientService.entity.Patient;
import com.Maccess.patientService.repository.PatientRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepo patientRepo;

    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public List<PatientResponseDto> getPatients() {
        List<Patient> patients = patientRepo.findAll();
        List<PatientResponseDto> patientResponseDtos = patients.stream()
                .map(PatientMapper::toDto).toList();
        return patientResponseDtos;
    }
}
