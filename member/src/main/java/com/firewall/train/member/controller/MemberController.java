package com.firewall.train.member.controller;

import cn.hutool.core.collection.CollUtil;
import com.firewall.train.common.resp.CommonResp;
import com.firewall.train.member.domain.Member;
import com.firewall.train.member.domain.MemberExample;
import com.firewall.train.member.req.MemberRegisterReq;
import com.firewall.train.member.servece.MemberService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World123!";
    }

    @GetMapping("/count")
    public CommonResp<Integer> count() {
        int count = memberService.count();
        CommonResp<Integer> resp = new CommonResp<>();
        resp.setContent(count);
        return resp;
    }

    @PostMapping("/register")
    public CommonResp<Long> register(MemberRegisterReq req) {
        long id = memberService.register(req);
        CommonResp<Long> resp = new CommonResp<>();
        resp.setContent(id);
        return resp;

    }
}
