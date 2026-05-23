package com.prachiii18.HospitalManagementSystem.service;

import com.prachiii18.HospitalManagementSystem.entity.PatientEntity;
import com.prachiii18.HospitalManagementSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional
    public void testPatientTransaction(){
        PatientEntity p1= patientRepository.findById(1L).orElseThrow();
        PatientEntity p2= patientRepository.findById(1L).orElseThrow();

        System.out.println(p1+" "+ p2);
        System.out.println(p1 == p2);
    }

    @Transactional
    public void deletePatient(Long patientId){
        patientRepository.findById(patientId).orElseThrow();
        patientRepository.deleteById(patientId);
    }
}
