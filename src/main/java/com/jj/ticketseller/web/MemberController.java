package com.jj.ticketseller.web;

import com.jj.ticketseller.domain.Member;
import com.jj.ticketseller.dto.MemberDTO;
import com.jj.ticketseller.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    @GetMapping(value = "/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberDTO());
        return "members/createMemberForm";
    }
    @PostMapping(value = "/members/new")
    public String create(@Valid MemberDTO memberDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "members/createMemberForm";
        }

        memberService.join(memberDTO);
        return "redirect:/";
    }

    @GetMapping(value = "/members") public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }
}