package com.example.skptemp.domain.user.service;

import com.example.skptemp.domain.user.dto.SocialAuthResponse;
import com.example.skptemp.domain.user.dto.SocialUserResponse;
import com.example.skptemp.domain.user.dto.SocialUserResult;
import com.example.skptemp.domain.user.entity.User;
import com.example.skptemp.domain.user.entity.UserDetailsImpl;
import com.example.skptemp.domain.user.repository.UserRepository;
import com.example.skptemp.global.configuration.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final LoginService loginService;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    @Override
    public SocialUserResponse doSocialLogin(String token) {
        SocialAuthResponse authResponse = loginService.getAccessToken(token);
        log.info("service auth response token: {}", authResponse.getAccessToken());
        SocialUserResult userResult = loginService.getUserInfo(authResponse.getAccessToken());

        Long kakaoId = userResult.getId();
        // TODO: DB에 없는 유저의 경우 어떻게 처리할 지
        Optional<User> userOpt = userRepository.findByKakaoId(kakaoId);

        if(userOpt.isEmpty())
            return new SocialUserResponse(false, null);

        return new SocialUserResponse(true, userResult);
    }
    @Override
    public SocialUserResponse doSocialSignup(String token, String firstName, String lastName) {
        SocialAuthResponse authResponse = loginService.getAccessToken(token);
        SocialUserResult userResult = loginService.getUserInfo(authResponse.getAccessToken());

        User user = User.createUser(firstName, lastName, userResult.getId());
        userRepository.save(user);
        return new SocialUserResponse(true, userResult);
    }
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User findByKakaoId(Long kakaoId){
        return userRepository.findByKakaoId(kakaoId).orElseThrow();
    }

    @Override
    public String createJwt(Long id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(""));
        UserDetailsImpl userDetails = new UserDetailsImpl(user);
        Long expiredMs = 1000 * 60 * 60 * 24 * 7L; //TODO: 토큰 만료 기간은 7일로 설정
        return jwtProvider.createToken(userDetails, expiredMs);
    }
}
