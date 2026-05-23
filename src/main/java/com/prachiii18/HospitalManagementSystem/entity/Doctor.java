package com.prachiii18.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(length = 100)
    private String specialization;

    @OneToMany(mappedBy = "doctor", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private Set<Appointment> appointments= new HashSet<>();
}
