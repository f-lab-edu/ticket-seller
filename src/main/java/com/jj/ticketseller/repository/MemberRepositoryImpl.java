package com.jj.ticketseller.repository;

import com.jj.ticketseller.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberCustomRepository{
    private final MemberRepository memberRepository;

    @Override
    public void save(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findOne(Long id) {
        return memberRepository.findOne(id);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public List<Member> findByName(String name) {
        return memberRepository.findByName(name);
    }
}
