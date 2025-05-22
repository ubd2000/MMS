package com.study.redisstudy.leaderboard.controller;

import com.study.redisstudy.leaderboard.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DongMin Kim
 */
@RestController("LeaderboardApiController")
@RequiredArgsConstructor
public class ApiController {

    private final RankingService rankingService;

    @GetMapping("/setScore")
    public Boolean setScore(@RequestParam String userId, @RequestParam int score) {
        return rankingService.setUserScore(userId, score);
    }

    @GetMapping("/getRank")
    public Long getUserRank(@RequestParam String userId) {
        return rankingService.getUserRank(userId);
    }

    @GetMapping("/getTopRank")
    public List<String> getTopRank() {
        return rankingService.getTopRank(3);
    }
}
