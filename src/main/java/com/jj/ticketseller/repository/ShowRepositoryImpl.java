package com.jj.ticketseller.repository;

import com.jj.ticketseller.domain.Show;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ShowRepositoryImpl implements ShowCustomRepository {
    private final ShowRepository showRepository;
    @Override
    public Optional<Show> findOne(Long id) {
        return showRepository.findOne(id);
    }

    @Override
    public List<Show> findAll() {
        return showRepository.findAll();
    }

    @Override
    public List<Show> findByName(String name) {
        return showRepository.findByName(name);
    }
}