package com.jj.ticketseller.service;

import com.jj.ticketseller.domain.Member;
import com.jj.ticketseller.repository.WaitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WaitService {
    private final WaitRepository waitRepository;

    @Transactional
    public Long addWait(long id, Member member) {
        long waitNumber = waitRepository.increaseWaitNumber(id);
        waitRepository.addQueue(id, member, waitNumber);

        return waitNumber;
    }
}