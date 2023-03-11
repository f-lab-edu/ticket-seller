package com.jj.ticketseller.repository;

import com.jj.ticketseller.domain.Member;

import java.util.List;


public interface MemberCustomRepository {
    void save(Member member);
    Member findOne(Long id);
    List<Member> findAll();
    List<Member> findByName(String name);
}
