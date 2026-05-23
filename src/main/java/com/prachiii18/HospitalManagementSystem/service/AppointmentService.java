package com.prachiii18.HospitalManagementSystem.service;

import com.prachiii18.HospitalManagementSystem.entity.Appointment;
import com.prachiii18.HospitalManagementSystem.entity.Doctor;
import com.prachiii18.HospitalManagementSystem.entity.PatientEntity;
import com.prachiii18.HospitalManagementSystem.repository.AppointmentRepository;
import com.prachiii18.HospitalManagementSystem.repository.DoctorRepository;
import com.prachiii18.HospitalManagementSystem.repository.InsuranceRepository;
import com.prachiii18.HospitalManagementSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    @Transactional
    public Appointment createANewAppointment( Appointment appointment, Long patientId, Long doctorId){
       PatientEntity patient= patientRepository.findById(patientId).orElseThrow();
       Doctor doctor= doctorRepository.findById(doctorId).orElseThrow();

       appointment.setPatient(patient);
       appointment.setDoctor(doctor);
       appointmentRepository.save(appointment);
       return appointment;
    }
}
