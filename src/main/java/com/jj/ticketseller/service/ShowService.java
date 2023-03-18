package com.jj.ticketseller.service;

import com.jj.ticketseller.domain.Show;
import com.jj.ticketseller.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowService {
    private final ShowRepository showRepository;

    public List<Show> findShows() {
        return showRepository.findAll();
    }

    public List<Show> findByName(String name) {
        return showRepository.findByName(name);
    }

    public int getPrice(Long id) {
        return showRepository.findOne(id)
                .map(Show::getPrice)
                .orElse(0);
    }
}