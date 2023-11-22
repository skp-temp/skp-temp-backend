package com.example.skptemp.domain.user.service;

import com.example.skptemp.domain.user.dto.SocialAuthResponse;
import com.example.skptemp.domain.user.dto.SocialUserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final LoginService loginService;
    @Override
    public String doSocialLogin(String token) {
        SocialAuthResponse authResponse = loginService.getAccessToken(token);
        log.info("service auth response token: {}", authResponse.getAccessToken());
        SocialUserResponse userResponse = loginService.getUserInfo(authResponse.getAccessToken());
        return userResponse.getProfileNickName();
    }
}
