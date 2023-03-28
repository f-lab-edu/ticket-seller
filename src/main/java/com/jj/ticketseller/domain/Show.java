package com.jj.ticketseller.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class Show {
    @Id @GeneratedValue()
    private Long id;

    private String name;

    private int price;
}