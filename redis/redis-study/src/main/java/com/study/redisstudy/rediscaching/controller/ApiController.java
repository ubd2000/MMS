package com.study.redisstudy.rediscaching.controller;

import com.study.redisstudy.rediscaching.dto.UserProfile;
import com.study.redisstudy.rediscaching.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DongMin Kim
 */
@RestController
@RequiredArgsConstructor
public class ApiController {

    private final UserService userService;

    @GetMapping("/users/{userId}/profile")
    public UserProfile getUserProfile(@PathVariable(value = "userId") String userId) {
        return userService.getUserProfile(userId);
    }
}
