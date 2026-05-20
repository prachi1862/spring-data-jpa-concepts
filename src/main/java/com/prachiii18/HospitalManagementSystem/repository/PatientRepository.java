package com.prachiii18.HospitalManagementSystem.repository;

import com.prachiii18.HospitalManagementSystem.dto.BloodGroupStats;
import com.prachiii18.HospitalManagementSystem.dto.CPatientInfo;
import com.prachiii18.HospitalManagementSystem.dto.IPatientInfo;
import com.prachiii18.HospitalManagementSystem.entity.BloodGroupType;
import com.prachiii18.HospitalManagementSystem.entity.PatientEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.List;
@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    @Query("select p.id as id, p.name as name, p.email as email from PatientEntity p")
    List<IPatientInfo> getAllPatientsInfo();

    @Query("SELECT new com.prachiii18.HospitalManagementSystem.dto.CPatientInfo(p.id, p.name) "+ "from PatientEntity p")
    List<CPatientInfo> getAllPatientsInfoConcrete();

    @Query("SELECT new com.prachiii18.HospitalManagementSystem.dto.BloodGroupStats(p.bloodGroupType, COUNT(p))"+
    "from PatientEntity p group by p.bloodGroupType order by COUNT(p)")
    List<BloodGroupStats> getAllBloodGroupTypes();

    @Transactional
    @Modifying
    @Query("UPDATE PatientEntity p set p.name= :name where p.id= :id")
    int updatePatientNameWithId(@Param("name") String name, @Param("id") Long id);
}
