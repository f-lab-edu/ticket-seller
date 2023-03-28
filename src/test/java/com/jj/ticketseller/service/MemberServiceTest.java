package com.jj.ticketseller.service;

import com.jj.ticketseller.domain.Member;

import com.jj.ticketseller.dto.MemberDTO;
import com.jj.ticketseller.repository.MemberCustomRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {
    private final String name = "JJ";
    private final String city = "city";
    private final String street = "street";
    private final String zipcode = "zipcode";
    @InjectMocks
    private MemberService memberService;
    @Mock
    private MemberCustomRepository memberRepository;

    @Test
    public void join() throws IllegalStateException {
        // given
        MemberDTO memberDTO = new MemberDTO(name, city, street, zipcode);
        Member member = new Member(name);
        member.setId(1L);
        when(memberRepository.findByName(name)).thenReturn(Collections.emptyList());
        doAnswer(invocation -> {
            Member argMember = invocation.getArgument(0);
            argMember.setId(1L);
            return null;
        }).when(memberRepository).save(any(Member.class));
        // when
        long memberId = memberService.join(memberDTO);
        // then
        assertEquals(1L, memberId);
        verify(memberRepository).findByName(name);
        verify(memberRepository).save(any(Member.class));
    }

    @Test
    public void duplicateMemberException() {
        // given
        MemberDTO memberDTO = new MemberDTO(name, city, street, zipcode);
        Member member = new Member(name);
        when(memberRepository.findByName(member.getName())).thenReturn(Collections.singletonList(member));
        // when & then
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> memberService.join(memberDTO));
        assertEquals("이미 존재하는 회원입니다.", exception.getMessage());
        verify(memberRepository).findByName(member.getName());
    }

    @Test
    public void testFindMembers() {
        // given
        Member member = new Member(name);
        when(memberRepository.findAll()).thenReturn(Collections.singletonList(member));
        // when
        List<Member> members = memberService.findMembers();
        // then
        assertEquals(Collections.singletonList(member), members);
        verify(memberRepository).findAll();
    }

    @Test
    public void testFindOne() {
        // given
        Long id = 1L;
        Member member = new Member(name);
        member.setId(id);
        when(memberRepository.findOne(id)).thenReturn(member);
        // when
        Member foundMember = memberService.findOne(id);
        // then
        assertEquals(member, foundMember);
        verify(memberRepository).findOne(id);
    }
}