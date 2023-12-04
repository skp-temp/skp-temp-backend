package com.example.skptemp.global.configuration;

import com.example.skptemp.domain.user.entity.User;
import com.example.skptemp.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestAccountApplicationRunner implements ApplicationRunner {
    private final UserRepository userRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        userRepository.save(User.createUser("강", "동훈", 1L));
    }
}
