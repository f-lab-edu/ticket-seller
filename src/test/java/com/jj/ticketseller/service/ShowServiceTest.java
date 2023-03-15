package com.jj.ticketseller.service;

import com.jj.ticketseller.domain.Show;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class ShowServiceTest {
    @Mock
    private ShowService showService;

    @Test
    public void getPriceSuccess() {
        Show show = new Show();
        show.setPrice(1000);

        Mockito.when(showService.getPrice(show.getId())).thenReturn(show.getPrice());

        assertEquals(1000, showService.getPrice(show.getId()));
    }

    @Test
    public void getPriceFail() {
        Mockito.when(showService.getPrice(1L)).thenReturn(0);

        assertEquals(0, showService.getPrice(1L));
    }
}