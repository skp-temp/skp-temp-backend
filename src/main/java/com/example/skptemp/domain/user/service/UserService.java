package com.example.skptemp.domain.user.service;

import com.example.skptemp.domain.user.dto.SocialUserResponse;
import com.example.skptemp.domain.user.entity.User;

public interface UserService {
    SocialUserResponse doSocialLogin(String token);
    SocialUserResponse doSocialSignup(String token, String firstName, String lastName);
    User findById(Long id);
    User findByKakaoId(Long kakaoId);
    String createJwt(Long id);
}
