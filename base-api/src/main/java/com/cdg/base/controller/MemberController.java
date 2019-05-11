package com.cdg.base.controller;

import com.cdg.base.domain.Member;
import com.cdg.base.persistence.MemberRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log
@Controller
@RequestMapping("/member/")
public class MemberController {

    @Autowired
    PasswordEncoder pwEncoder;

    @Autowired
    MemberRepository repository;

    @GetMapping("/join")
    public void join(){

    }

    @PostMapping("/join")
    public String joinPost(@ModelAttribute("member") Member member){

        System.out.println("Member : " + member);

        String encryptPw = pwEncoder.encode(member.getUpw());

        System.out.println("en : " + encryptPw);

        member.setUpw(encryptPw);

        repository.save(member);

        return "/member/joinResult";

    }

}
