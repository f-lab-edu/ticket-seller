package com.jj.ticketseller.repository;

import com.jj.ticketseller.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class WaitRepository {
    private final RedisTemplate<String, Long> redisTemplateLong;
    private final RedisTemplate<String, Member> redisTemplateMember;

    private static final String KEY = "wait:%d";

    public long increaseWaitNumber(long id) {
        String key = String.format(KEY, id);
        return redisTemplateLong.opsForValue().increment(key + ":wait_number", 1L);
    }

    public boolean addQueue(long id, Member member, long waitNumber) {
        String key = String.format(KEY, id);
        return redisTemplateMember.opsForZSet().add(key + ":queue", member, waitNumber);
    }
}