package com.study.redisstudy.leaderboard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author DongMin Kim
 */
@Service
@RequiredArgsConstructor
public class RankingService {

    private static final String LEADERBOARD_KEY = "leaderBoard";
    private final StringRedisTemplate redisTemplate;

    public boolean setUserScore(String userId, int score) {
        ZSetOperations <String, String> zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add(LEADERBOARD_KEY, userId, score);

        return true;
    }

    public Long getUserRank(String userId) {
        ZSetOperations <String, String> zSetOperations = redisTemplate.opsForZSet();
        Long rank = zSetOperations.reverseRank(LEADERBOARD_KEY, userId);

        return rank;
    }

    public List<String> getTopRank(int limit) {
        ZSetOperations <String, String> zSetOperations = redisTemplate.opsForZSet();
        Set<String> rangeSet = zSetOperations.reverseRange(LEADERBOARD_KEY, 0, limit - 1);

        return new ArrayList<>(rangeSet);
    }
}
