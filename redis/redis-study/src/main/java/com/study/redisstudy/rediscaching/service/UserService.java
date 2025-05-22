package com.study.redisstudy.rediscaching.service;

import com.study.redisstudy.rediscaching.dto.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author DongMin Kim
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final ExternalApiService externalApiService;
    private final StringRedisTemplate redisTemplate;

    public UserProfile getUserProfile(String userId) {

        String userName = null;

        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String cachedName = ops.get("nameKey:" + userId);

        // Cache-Aside Pattern
        if (cachedName != null) {
            userName = cachedName;
        } else {
            // 캐시가 없을 경우 외부 API 호출
            userName = externalApiService.getUserName(userId);
            // 캐시에 저장
            ops.set("nameKey:" + userId, userName, 5, TimeUnit.SECONDS);
        }

//        String userName = externalApiService.getUserName(userId);
        int userAge = externalApiService.getUserAge(userId);
        return new UserProfile(userName, userAge);
    }
}
