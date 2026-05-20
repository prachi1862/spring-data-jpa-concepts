package com.prachiii18.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String reason;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @ManyToOne
    @JoinColumn(nullable = false)
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;
}
