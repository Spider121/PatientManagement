package com.Maccess.patientService.service;

import com.Maccess.patientService.exception.EmailAlreadyExistException;
import com.Maccess.patientService.exception.PatientNotFoundException;
import com.Maccess.patientService.mapper.PatientMapper;
import com.Maccess.patientService.dto.PatientRequestDto;
import com.Maccess.patientService.dto.PatientResponseDto;
import com.Maccess.patientService.entity.Patient;
import com.Maccess.patientService.repository.PatientRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepo patientRepo;

    public PatientService(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    public List<PatientResponseDto> getPatients() {
        List<Patient> patients = patientRepo.findAll();
        return patients.stream()
                .map(PatientMapper::toDto).toList();
    }

    public PatientResponseDto createPatient(PatientRequestDto patientRequestDto) {
        if (patientRepo.existsByEmail(patientRequestDto.getEmail())) {
            throw new EmailAlreadyExistException("A Patient With this Email Already Exist");
        }
        Patient patient = patientRepo.save(PatientMapper.toEntity(patientRequestDto));
        return PatientMapper.toDto(patient);
    }

    public PatientResponseDto updatePatient(Long id, PatientRequestDto patientRequestDto) {
        Patient patient = patientRepo.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient Not Found With this id{}" + id));
        if (patientRepo.existsByEmailAndIdNot(patientRequestDto.getEmail(),id)) {
            throw new EmailAlreadyExistException("A Patient With this Email Already Exist");
        }
        patient.setName(patientRequestDto.getName());
        patient.setEmail(patientRequestDto.getEmail());
        patient.setAddress(patientRequestDto.getAddress());
        patient.setDateOFBirth(LocalDate.parse(patientRequestDto.getDateOfBirth()));
        Patient updatedPatient = patientRepo.save(patient);
        return PatientMapper.toDto(updatedPatient);
    }

    public String deletePatient(Long id){
        Patient patient = patientRepo.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient Not Found With this id{}" + id));
        patientRepo.deleteById(id);
        return "Patient Deleted Successfully";
    }
}
