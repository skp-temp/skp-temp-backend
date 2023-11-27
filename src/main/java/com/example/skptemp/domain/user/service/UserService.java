package com.example.skptemp.domain.user.service;

import com.example.skptemp.domain.user.dto.SocialUserResponse;
import com.example.skptemp.domain.user.entity.User;

public interface UserService {
    SocialUserResponse doSocialLogin(String token);
    SocialUserResponse doSocialSignup(String token);
    User findById(Long id);
}
