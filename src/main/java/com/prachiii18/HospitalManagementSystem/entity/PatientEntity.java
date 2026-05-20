package com.prachiii18.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime birthDate;
    private String gender;
    private String email;
    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroupType;
    @CreationTimestamp
    private LocalDate createdAt;
}
