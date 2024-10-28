package com.firewall.train.member.servece;

import com.firewall.train.member.mapper.MemberMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Resource
    private MemberMapper memberMapper;
    public int count() {
        return memberMapper.count();
    }
}
