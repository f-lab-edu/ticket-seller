package com.jj.ticketseller.service;

import com.jj.ticketseller.domain.Show;
import com.jj.ticketseller.repository.ShowRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ShowServiceTest {
    @InjectMocks
    private ShowService showService;
    @Mock
    private ShowRepository showRepository;

    @Test
    public void findShows() {
        // given
        Show show = new Show();
        show.setName("Test");
        when(showRepository.findAll()).thenReturn(Collections.singletonList(show));
        // when
        List<Show> result = showService.findShows();
        // then
        assertEquals(Collections.singletonList(show), result);
        verify(showRepository).findAll();
    }

    @Test
    public void findByName() {
        // given
        String name = "Test";
        Show show = new Show();
        show.setName(name);
        when(showRepository.findByName(name)).thenReturn(Collections.singletonList(show));
        // when
        List<Show> result = showService.findByName(name);
        // then
        assertEquals(Collections.singletonList(show), result);
        verify(showRepository).findByName(name);
    }

    @Test
    public void getPriceSuccess() {
        // given
        long id = 1L;
        Show show = new Show();
        show.setId(id);
        show.setPrice(1000);
        when(showRepository.findOne(id)).thenReturn(Optional.of(show));
        // when
        int price = showService.getPrice(id);
        // then
        assertEquals(1000, price);
        verify(showRepository).findOne(id);
    }

    @Test
    public void getPriceFail() {
        // given
        long id = 1L;
        when(showRepository.findOne(id)).thenReturn(Optional.empty());
        // when
        int price = showService.getPrice(id);
        // then
        assertEquals(0, price);
        verify(showRepository).findOne(id);
    }
}