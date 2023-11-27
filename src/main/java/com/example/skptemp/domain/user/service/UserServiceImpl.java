package com.example.skptemp.domain.user.service;

import com.example.skptemp.domain.user.dto.SocialAuthResponse;
import com.example.skptemp.domain.user.dto.SocialUserResponse;
import com.example.skptemp.domain.user.entity.User;
import com.example.skptemp.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final LoginService loginService;
    private final UserRepository userRepository;
    @Override
    public SocialUserResponse doSocialLogin(String token) {
        SocialAuthResponse authResponse = loginService.getAccessToken(token);
        log.info("service auth response token: {}", authResponse.getAccessToken());
        SocialUserResponse userResponse = loginService.getUserInfo(authResponse.getAccessToken());

        Long kakaoId = userResponse.getId();
        // TODO: DB에 없는 유저의 경우 어떻게 처리할 지
        userRepository.findByKakaoId(kakaoId).orElseThrow();

        return userResponse;
    }

    @Override
    public SocialUserResponse doSocialSignup(String token) {
        SocialAuthResponse authResponse = loginService.getAccessToken(token);
        SocialUserResponse userResponse = loginService.getUserInfo(authResponse.getAccessToken());


    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
