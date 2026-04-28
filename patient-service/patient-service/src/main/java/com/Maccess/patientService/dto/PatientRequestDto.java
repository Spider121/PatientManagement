package com.Maccess.patientService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientRequestDto {

    @NotBlank( message = "Name is Required")
    @Size(max = 100, message = "Name Cannot Be Exceed 100 characters")
    private String name;

    @NotBlank(message = "Email is Required")
    @Email(message = "Email should be valid")

    private String email;

    @NotBlank(message = "Address is Required")
    private String Address;

    @NotBlank(message = "Date Of Birth is Required")
    private String dateOfBirth;

    @NotBlank(message = "registration Date is Required")
    private String registrationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public PatientRequestDto() {
    }

    public PatientRequestDto(String name, String email, String address, String dateOfBirth, String registrationDate) {
        this.name = name;
        this.email = email;
        Address = address;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
    }
}
