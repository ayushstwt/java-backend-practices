package com.ayshriv.bootrestproj12miniprojectapidevelopment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TOURIST_DATA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tourist {
    @Id
    @SequenceGenerator(name = "TOURIST_SEQ", sequenceName = "TOURIST_SEQ", allocationSize = 1,initialValue = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOURIST_SEQ")
    private Integer id;

    @Column(length = 20)
    @NonNull
    private String tName;

    @Column(length = 20)
    @NonNull
    private String tAddress;

    @Column(length = 20)
    @NonNull
    private String packageType;

    @NonNull
    private Double budget;

    @NonNull
    private LocalDateTime startDate;

    @NonNull
    private LocalDateTime endDate;
}
