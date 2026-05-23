package com.prachiii18.HospitalManagementSystem.service;

import com.prachiii18.HospitalManagementSystem.entity.Doctor;
import com.prachiii18.HospitalManagementSystem.repository.AppointmentRepository;
import com.prachiii18.HospitalManagementSystem.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {
    @Autowired
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;
    @Transactional
    public void deleteDoctor(Long doctorId){
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();
        doctorRepository.delete(doctor);
    }
}
