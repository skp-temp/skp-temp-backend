package com.example.skptemp.domain.charm.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Charm {
    @Builder
    public Charm(Long categoryId, Long characterId, String finalGoal, String dailyGoal) {
        this.categoryId = categoryId;
        this.characterId = characterId;
        this.finalGoal = finalGoal;
        this.dailyGoal = dailyGoal;
    }

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
