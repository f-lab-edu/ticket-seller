package com.jj.ticketseller.service;

import com.jj.ticketseller.domain.Show;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ShowServiceTest {
    @Mock
    private ShowService showService;

    @Test
    public void findShows() {
        // given
        Show show = new Show();
        show.setName("Test");
        when(showService.findShows()).thenReturn(Collections.singletonList(show));
        // when
        List<Show> result = showService.findShows();
        // then
        assertEquals(Collections.singletonList(show), result);
        verify(showService).findShows();
    }

    @Test
    public void findByName() {
        // given
        String name = "Test";
        Show show = new Show();
        show.setName(name);
        when(showService.findByName(name)).thenReturn(Collections.singletonList(show));
        // when
        List<Show> result = showService.findByName(name);
        // then
        assertEquals(Collections.singletonList(show), result);
        verify(showService).findByName(name);
    }

    @Test
    public void getPriceSuccess() {
        // given
        long id = 1L;
        Show show = new Show();
        show.setId(id);
        show.setPrice(1000);
        when(showService.getPrice(id)).thenReturn(show.getPrice());
        // when
        int price = showService.getPrice(id);
        // then
        assertEquals(1000, price);
        verify(showService).getPrice(id);
    }

    @Test
    public void getPriceFail() {
        // given
        long id = 1L;
        when(showService.getPrice(id)).thenReturn(0);
        // when
        int price = showService.getPrice(id);
        // then
        assertEquals(0, price);
        verify(showService).getPrice(id);
    }
}