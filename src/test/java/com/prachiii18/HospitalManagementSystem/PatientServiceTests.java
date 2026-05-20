package com.prachiii18.HospitalManagementSystem;

import com.prachiii18.HospitalManagementSystem.dto.BloodGroupStats;
import com.prachiii18.HospitalManagementSystem.dto.CPatientInfo;
import com.prachiii18.HospitalManagementSystem.dto.IPatientInfo;
import com.prachiii18.HospitalManagementSystem.entity.BloodGroupType;
import com.prachiii18.HospitalManagementSystem.entity.PatientEntity;
import com.prachiii18.HospitalManagementSystem.repository.PatientRepository;
import com.prachiii18.HospitalManagementSystem.service.PatientService;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatients(){
        patientService.testPatientTransaction();
    }
}
