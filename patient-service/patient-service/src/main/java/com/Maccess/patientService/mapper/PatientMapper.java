package com.Maccess.patientService.mapper;

import com.Maccess.patientService.dto.PatientRequestDto;
import com.Maccess.patientService.dto.PatientResponseDto;
import com.Maccess.patientService.entity.Patient;

import java.time.LocalDate;

public class PatientMapper {

    public static PatientResponseDto toDto(Patient patient) {
        PatientResponseDto patientResponseDto = new PatientResponseDto();
        patientResponseDto.setId(patient.getId().toString());
        patientResponseDto.setName(patient.getName());
        patientResponseDto.setEmail(patient.getEmail());
        patientResponseDto.setAddress(patient.getAddress());
        patientResponseDto.setDateOfBirth(patient.getEmail());
        return patientResponseDto;
    }

    public static Patient toEntity(PatientRequestDto patientRequestDto) {
        Patient newPatient = new Patient();

        newPatient.setName(patientRequestDto.getName());
        newPatient.setEmail(patientRequestDto.getEmail());
        newPatient.setAddress(patientRequestDto.getAddress());
        newPatient.setDateOFBirth(LocalDate.parse(patientRequestDto.getDateOfBirth()));
        newPatient.setRegisteredDate(LocalDate.parse(patientRequestDto.getRegistrationDate()));
        return newPatient;
    }
}
