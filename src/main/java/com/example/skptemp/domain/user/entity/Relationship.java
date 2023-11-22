package com.example.skptemp.domain.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
//@Entity
public class Relationship {
    @Id @Column(name = "relationship_id")
    private Long id;
//    @ManyToOne(fetch = FetchType.EAGER)
    private User userA;
//    @OneToMany
    private User userB;
}
