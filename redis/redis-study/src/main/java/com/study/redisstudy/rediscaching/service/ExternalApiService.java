package com.study.redisstudy.rediscaching.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author DongMin Kim
 */
@Service
public class ExternalApiService {

    public String getUserName(String userId) {
        //외부 서비스나 DB 호출
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Getting user userName from other service..");

        if (userId.equals("A")) {
            return "Adam";
        }
        if (userId.equals("B")) {
            return "Bob";
        }

        return "";
    }

    /**
     * Spring Cache Manager를 사용하여 캐싱을 적용한 메서드
     *
     * @param userId
     * @return
     */
    @Cacheable(cacheNames = "userAgeCache", key = "#userId")
    public int getUserAge(String userId) {
        //외부 서비스나 DB 호출
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Getting user age from other service..");

        if (userId.equals("A")) {
            return 28;
        }
        if (userId.equals("B")) {
            return 32;
        }

        return 0;
    }
}
