package com.jj.ticketseller.service;

import com.jj.ticketseller.domain.Member;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
@Transactional
public class MemberServiceTest {
    @Mock
    private MemberService memberService;


    @Test
    public void signup() throws Exception {
        Member member = new Member();

        Mockito.when(memberService.join(member)).thenReturn(member.getId());
        Mockito.when(memberService.findOne(member.getId())).thenReturn(member);

        Long savedId = memberService.join(member);

        assertEquals(member, memberService.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void duplicateMemberException() throws Exception {
        Member member1 = new Member();
        member1.setName("1");

        Member member2 = new Member();
        member2.setName("1");

        Mockito.when(memberService.join(member1)).thenReturn(member1.getId());
        Mockito.when(memberService.join(member1)).thenThrow(IllegalStateException.class);

        memberService.join(member1);
        memberService.join(member2);

        fail("예외 발생");
    }
}