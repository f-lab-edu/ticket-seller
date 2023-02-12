package com.jj.ticketseller.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue()
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "member")
    private List<Reservation> reservations = new ArrayList<>();
}
