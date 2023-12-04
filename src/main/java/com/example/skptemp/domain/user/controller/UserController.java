package com.example.skptemp.domain.user.controller;

import com.example.skptemp.domain.user.dto.SocialLoginRequest;
import com.example.skptemp.domain.user.dto.SocialUserResponse;
import com.example.skptemp.domain.user.entity.User;
import com.example.skptemp.domain.user.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping("/kakao-login")
    public ResponseEntity<Object> doKakaoLogin(HttpServletResponse response, @RequestParam String code){
        log.info("token: {}", code);
        SocialUserResponse socialUserResponse = userService.doSocialLogin(code);
        Long kakaoId = socialUserResponse.getSocialUserResult().getId();
        User userByKakaoId = userService.findByKakaoId(kakaoId);
        String jwt = userService.createJwt(userByKakaoId.getId());
        response.addHeader("authorization", jwt);

        // get login token with authorization token
        return ResponseEntity.created(URI.create("/kakao-login"))
                .body(socialUserResponse);
    }

    @GetMapping("/create-token")
    public String createToken(){
        //TODO: 테스트 계정 생성 필요
        return userService.createJwt(1L);
    }
}
