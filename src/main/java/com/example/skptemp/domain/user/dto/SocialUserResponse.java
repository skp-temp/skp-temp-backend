package com.example.skptemp.domain.user.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SocialUserResponse {
    private Long id;
    private LocalDateTime connectedAt;
    private SocialUserProperties properties;
}
