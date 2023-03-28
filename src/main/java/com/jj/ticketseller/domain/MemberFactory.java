package com.jj.ticketseller.domain;

import com.jj.ticketseller.dto.MemberDTO;

public class MemberFactory {
    public static Member createMember(MemberDTO memberDTO) {
        Member member = new Member(memberDTO.getName());
        member.setAddress(new Address(memberDTO.getCity(), memberDTO.getStreet(), memberDTO.getZipcode()));

        return member;
    }
}