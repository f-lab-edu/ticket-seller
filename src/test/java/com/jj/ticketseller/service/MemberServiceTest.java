package com.jj.ticketseller.service;

import com.jj.ticketseller.domain.Member;

import com.jj.ticketseller.domain.MemberFactory;
import com.jj.ticketseller.dto.MemberDTO;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {
    private final String name = "JJ";
    private final String city = "city";
    private final String street = "street";
    private final String zipcode = "zipcode";
    @Mock
    private MemberService memberService;

    @Test
    public void join() throws IllegalStateException {
        MemberDTO memberDTO = new MemberDTO(name, city, street, zipcode);
        Member member = MemberFactory.createMember(name, city, street, zipcode);

        Mockito.when(memberService.join(memberDTO))
                .thenReturn(member.getId());
        Mockito.when(memberService.findOne(member.getId())).thenReturn(member);

        Long savedId = memberService.join(memberDTO);

        assertEquals(member, memberService.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void duplicateMemberException() throws IllegalStateException {
        MemberDTO memberDTO = new MemberDTO(name, city, street, zipcode);
        Member member = MemberFactory.createMember(name, city, street, zipcode);

        Mockito.when(memberService.join(memberDTO)).thenReturn(member.getId());
        Mockito.when(memberService.join(memberDTO)).thenThrow(IllegalStateException.class);

        memberService.join(memberDTO);
        memberService.join(memberDTO);

        fail("예외 발생");
    }
}