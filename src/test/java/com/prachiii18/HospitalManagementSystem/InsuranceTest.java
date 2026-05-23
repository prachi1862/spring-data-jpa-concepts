package com.prachiii18.HospitalManagementSystem;

import com.prachiii18.HospitalManagementSystem.entity.*;
import com.prachiii18.HospitalManagementSystem.repository.AppointmentRepository;
import com.prachiii18.HospitalManagementSystem.repository.DoctorRepository;
import com.prachiii18.HospitalManagementSystem.repository.InsuranceRepository;
import com.prachiii18.HospitalManagementSystem.repository.PatientRepository;
import com.prachiii18.HospitalManagementSystem.service.AppointmentService;
import com.prachiii18.HospitalManagementSystem.service.DoctorService;
import com.prachiii18.HospitalManagementSystem.service.InsuranceService;
import com.prachiii18.HospitalManagementSystem.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testAssignInsuranceToPatient() {
        Insurance insurance = Insurance.builder()
                .provider("HDFC")
                .policyNumber("HDFC_235")
                .validUntil(LocalDate.of(2030, 12, 18)).build();


        var updatedInsurance = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(updatedInsurance);

        patientService.deletePatient(1L);
    }

    @Test
    public void testCreateAppointment() {
        Appointment appointment = Appointment.builder()
                .reason("Cancer")
                .appointmentTime(LocalDateTime.of(2026, 6, 18, 5, 12, 2))
                .build();
        var updatedAppointment = appointmentService.createANewAppointment(appointment, 1L, 2L);
        System.out.println(updatedAppointment);

        patientService.deletePatient(1L);
    }

    @Test
    public void testDeleteDoctor() {

        Doctor doctor = doctorRepository.save(
                Doctor.builder()
                        .name("Daniel")
                        .email("doc@gmail.com")
                        .specialization("pediatrician")
                        .build()
        );

        PatientEntity patient = patientRepository.save(
                PatientEntity.builder()
                        .name("Dania")
                        .gender("female")
                        .email("d@gmail.com")
                        .birthDate(LocalDate.of(2003, 8, 9).atStartOfDay())
                        .bloodGroupType(BloodGroupType.A_Positive)
                        .build()
        );

        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.now())
                .reason("Diarrhoea")
                .doctor(doctor)
                .patient(patient)
                .build();

        appointmentRepository.save(appointment);

        doctorService.deleteDoctor(doctor.getId());

        System.out.println(appointmentRepository.findAll());
    }

}
