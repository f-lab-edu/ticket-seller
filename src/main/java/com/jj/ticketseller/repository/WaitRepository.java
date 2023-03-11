package com.jj.ticketseller.repository;

import com.jj.ticketseller.domain.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class WaitRepository {
    private final RedisTemplate redisTemplate;

    private static final String KEY = "wait:%d";
    @Autowired
    public WaitRepository(RedisTemplate<?, ?> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public long increaseWaitNumber(long id) {
        String key = String.format(KEY, id);
        return redisTemplate.opsForValue().increment(key + ":wait_number", 1L);
    }

    public boolean addQueue(long id, Member member, long waitNumber) {
        String key = String.format(KEY, id);
        return redisTemplate.opsForZSet().add(key + ":queue", member, waitNumber);
    }
}