package com.jj.ticketseller.repository;

import com.jj.ticketseller.domain.Show;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ShowRepositoryTest {
    @InjectMocks
    private ShowRepository showRepository;

    @Mock
    private EntityManager em;
    @Test
    public void testFindOne() {
        // given
        Show show = new Show();
        show.setId(1L);
        when(em.find(Show.class, 1L)).thenReturn(show);
        // when
        Optional<Show> result = showRepository.findOne(1L);
        // then
        assertEquals(Optional.of(show), result);
        verify(em).find(Show.class, 1L);
    }

    @Test
    public void testFindByName() {
        // given
        String name = "Test Show";
        Show show = new Show();
        show.setName(name);

        TypedQuery<Show> typedQuery = mock(TypedQuery.class);
        when(em.createQuery(any(String.class), eq(Show.class))).thenReturn(typedQuery);
        when(typedQuery.setParameter(any(String.class), any())).thenReturn(typedQuery);
        when(typedQuery.getResultList()).thenReturn(Collections.singletonList(show));
        // when
        List<Show> result = showRepository.findByName(name);
        // then
        assertEquals(Collections.singletonList(show), result);
        verify(em).createQuery("select s from Show s where s.name = :name", Show.class);
        verify(typedQuery).setParameter("name", name);
        verify(typedQuery).getResultList();
    }
}