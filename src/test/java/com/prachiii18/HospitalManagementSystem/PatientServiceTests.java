package com.prachiii18.HospitalManagementSystem;

import com.prachiii18.HospitalManagementSystem.dto.BloodGroupStats;
import com.prachiii18.HospitalManagementSystem.dto.CPatientInfo;
import com.prachiii18.HospitalManagementSystem.dto.IPatientInfo;
import com.prachiii18.HospitalManagementSystem.entity.BloodGroupType;
import com.prachiii18.HospitalManagementSystem.entity.PatientEntity;
import com.prachiii18.HospitalManagementSystem.repository.PatientRepository;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatients(){
        List<IPatientInfo> patientsList= patientRepository.getAllPatientsInfo();

        for(IPatientInfo patient:patientsList){
            System.out.println(patient);
        }
    }

    @Test
    public void testPatients2(){
        List<CPatientInfo> patientsList= patientRepository.getAllPatientsInfoConcrete();

        for(CPatientInfo patient:patientsList){
            System.out.println(patient);
        }
    }

    @Test
    public void testPatients3(){
        List<BloodGroupStats> patientsList= patientRepository.getAllBloodGroupTypes();

        for(var patient:patientsList){
            System.out.println(patient);
        }
    }

    @Test
    public void testPatients4(){
        int rowsAffected= patientRepository.updatePatientNameWithId("Tiya", 1L);
        System.out.println(rowsAffected);
    }
}
