package com.prachiii18.HospitalManagementSystem.service;

import com.prachiii18.HospitalManagementSystem.entity.Insurance;
import com.prachiii18.HospitalManagementSystem.entity.PatientEntity;
import com.prachiii18.HospitalManagementSystem.repository.InsuranceRepository;
import com.prachiii18.HospitalManagementSystem.repository.PatientRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId) {
        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance);
        return insurance;

    }

}
