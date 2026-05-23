package com.prachiii18.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "patient insurance", unique = true)
    private Insurance insurance; //owning side

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL) //inverse side
    private Set<Appointment> appointments= new HashSet<>();

}
