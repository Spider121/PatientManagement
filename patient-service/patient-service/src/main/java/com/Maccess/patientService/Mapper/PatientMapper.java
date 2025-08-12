package com.Maccess.patientService.Mapper;

import com.Maccess.patientService.dto.PatientResponseDto;
import com.Maccess.patientService.entity.Patient;

public class PatientMapper {

    public static PatientResponseDto toDto(Patient patient){
        PatientResponseDto patientResponseDto = new PatientResponseDto();
        patientResponseDto.setId(patient.getId().toString());
        patientResponseDto.setName(patient.getName());
        patientResponseDto.setEmail(patient.getEmail());
        patientResponseDto.setAddress(patient.getAddress());
        patientResponseDto.setDateOfBirth(patient.getEmail());
        return patientResponseDto;
    }
}
