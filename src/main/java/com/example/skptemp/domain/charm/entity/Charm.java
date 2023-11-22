package com.example.skptemp.domain.charm.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Charm {
    @Id @Column(name = "charm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long categoryId;
    private Long characterId;
    private LocalDateTime createdAt;
    private int charmLevel;
    private String finalGoal;
    private String dailyGoal;
}
