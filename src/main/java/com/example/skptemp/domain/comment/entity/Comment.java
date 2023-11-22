package com.example.skptemp.domain.comment.entity;

import com.example.skptemp.domain.charm.entity.Charm;
import com.example.skptemp.domain.item.entity.Item;
import com.example.skptemp.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Comment {
    @Column(name = "comment_id")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "charm_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Charm charm;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @JoinColumn(name = "item_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Item item;
    private String content;
    private LocalDateTime createdAt;
}
