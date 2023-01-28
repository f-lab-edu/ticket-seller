package com.jj.ticketseller.service;

import com.jj.ticketseller.domain.Member;
import com.jj.ticketseller.repository.MemberRepository;
import com.jj.ticketseller.repository.MemberCustomRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired MemberService memberService;

    @Test
    public void signup() throws Exception {
        Member member = new Member();

        Long savedId = memberService.join(member);

        assertEquals(member, memberService.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void duplicateMemberException() throws Exception {
        Member member1 = new Member();
        member1.setName("1");

        Member member2 = new Member();
        member2.setName("1");

        memberService.join(member1);
        memberService.join(member2);

        fail("예외 발생");
    }
}