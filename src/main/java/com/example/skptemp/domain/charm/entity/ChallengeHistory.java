package com.example.skptemp.domain.charm.entity;

import com.example.skptemp.domain.category.entity.Category;
import com.example.skptemp.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class ChallengeHistory {
    @Column(name = "history_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @JoinColumn(name = "category_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    @JoinColumn(name = "charm_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Charm charm;
}
