package com.jj.ticketseller.domain;

public class MemberFactory {
    public static Member createMember(String name) {
        return new Member(name);
    }

    public static Member createMember(String name, String city, String street, String zipcode) {
        Member member = new Member(name);
        member.setAddress(new Address(city, street, zipcode));

        return member;
    }
}