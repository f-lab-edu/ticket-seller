package com.jj.ticketseller.repository;

import com.jj.ticketseller.domain.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {

    Optional<Show> findOne(long id);
    List<Show> findByName(String name);
    List<Show> findAll();

}