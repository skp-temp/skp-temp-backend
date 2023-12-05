package com.example.skptemp.domain.badge.entity;

import jakarta.persistence.*;
import lombok.Builder;

@Builder
@Entity
public class Badge {
    @Id @Column(name = "badge_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    protected Badge(){}
}
