package com.jj.ticketseller.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Table(name = "reservations")
@Getter
public class Reservation {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
