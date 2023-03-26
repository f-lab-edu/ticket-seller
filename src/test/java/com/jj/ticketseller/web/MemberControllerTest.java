package com.jj.ticketseller.web;

import com.jj.ticketseller.domain.Member;
import com.jj.ticketseller.dto.MemberDTO;
import com.jj.ticketseller.service.MemberService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class MemberControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private MemberController memberController;

    @Mock
    private MemberService memberService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(memberController).build();
    }

    @Test
    public void createForm() throws Exception {
        mockMvc.perform(get("/members/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("members/createMemberForm"))
                .andExpect(model().attributeExists("memberForm"));
    }

    @Test
    public void create() throws Exception {
        mockMvc.perform(post("/members/new")
                .param("name", "JJ"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));

//        verify(memberService, times(1)).join(any(MemberDTO.class));
    }

    @Test
    public void list() throws Exception {
        List<Member> members = Arrays.asList(new Member("Test"), new Member("Test"));
        when(memberService.findMembers()).thenReturn(members);

        mockMvc.perform(get("/members"))
                .andExpect(status().isOk())
                .andExpect(view().name("members/memberList"))
                .andExpect(model().attributeExists("members"));

//        verify(memberService, times(1)).findMembers();
    }
}
