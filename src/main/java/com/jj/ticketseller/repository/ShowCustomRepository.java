package com.jj.ticketseller.repository;

import com.jj.ticketseller.domain.Show;

import java.util.List;

public interface ShowCustomRepository {
    Show findOne(Long id);
    List<Show> findAll();
    List<Show> findByName(String name);
}