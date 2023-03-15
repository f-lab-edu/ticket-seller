package com.jj.ticketseller.repository;

import com.jj.ticketseller.domain.Show;

import java.util.List;
import java.util.Optional;

public interface ShowCustomRepository {
    Optional<Show> findOne(Long id);
    List<Show> findAll();
    List<Show> findByName(String name);
}