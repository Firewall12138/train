package com.firewall.train.member.controller;

import com.firewall.train.member.servece.MemberService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World123!";
    }

    @GetMapping("/count")
    public int count() {
        int count = memberService.count();
        System.out.println(count);
        return memberService.count();
    }
}
