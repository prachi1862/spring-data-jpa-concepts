package com.prachiii18.HospitalManagementSystem.dto;

import com.prachiii18.HospitalManagementSystem.entity.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroupType bloodGroupType;
    private final Long count;
}
