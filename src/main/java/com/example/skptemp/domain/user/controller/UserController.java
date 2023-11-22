package com.example.skptemp.domain.user.controller;

import com.example.skptemp.domain.user.dto.SocialLoginRequest;
import com.example.skptemp.domain.user.service.UserService;
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
    public ResponseEntity<Object> doKakaoLogin(String code){
        log.info("token: {}", code);

        // get login token with authorization token
        return ResponseEntity.created(URI.create("/kakao-login"))
                .body(userService.doSocialLogin(code));
    }
}
