package com.jj.ticketseller.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisHash;

import java.util.HashMap;
import java.util.Map;


@RedisHash("wait")
@Getter @Setter
public class Wait {
    @Id @GeneratedValue()
    private Long id;

    @Reference
    private Map<Member, Long> queue = new HashMap<>();

    @Column(name = "wait_number")
    private Long waitNumber;

}