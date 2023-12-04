package com.example.skptemp.domain.charm.entity;

import com.example.skptemp.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
public class ChallengeHistory {
    @Column(name = "history_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    @JoinColumn(name = "charm_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Charm charm;

    private LocalDate historyDate;
}
