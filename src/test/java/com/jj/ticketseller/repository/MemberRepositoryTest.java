package com.jj.ticketseller.repository;

import com.jj.ticketseller.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MemberRepositoryTest {

    @InjectMocks
    private MemberRepository memberRepository;

    @Mock
    private EntityManager em;

    @Test
    public void findAll() {
        // given
        Member member1 = new Member("Test1");
        Member member2 = new Member("Test2");
        List<Member> expectedMembers = Arrays.asList(member1, member2);
        // when
        when(em.createQuery("select m from Member m", Member.class)).thenReturn(mock(TypedQuery.class));
        when(em.createQuery("select m from Member m", Member.class).getResultList()).thenReturn(expectedMembers);
        // then
        List<Member> actualMembers = memberRepository.findAll();
        assertEquals(expectedMembers, actualMembers);
    }

    @Test
    public void findByName() {
        // given
        String name = "Test";
        Member member = new Member("Test");
        List<Member> expectedMembers = Arrays.asList(member);
        // when
        TypedQuery<Member> typedQuery = mock(TypedQuery.class);
        when(em.createQuery("select m from Member m where m.name = :name", Member.class)).thenReturn(typedQuery);
        when(typedQuery.setParameter("name", name)).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(expectedMembers);
        // then
        List<Member> actualMembers = memberRepository.findByName(name);
        assertEquals(expectedMembers, actualMembers);
    }
}