package com.jj.ticketseller.service;

import com.jj.ticketseller.domain.Member;
import com.jj.ticketseller.domain.MemberFactory;
import com.jj.ticketseller.dto.MemberDTO;
import com.jj.ticketseller.repository.MemberRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepositoryImpl memberRepository;

    @Transactional
    public Long join(MemberDTO memberDTO) {
        Member member = MemberFactory.createMember(memberDTO);

        validateDuplicateMember(member);
        memberRepository.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
