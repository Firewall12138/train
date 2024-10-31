package com.firewall.train.member.servece;

import cn.hutool.core.collection.CollUtil;
import com.firewall.train.member.domain.Member;
import com.firewall.train.member.domain.MemberExample;
import com.firewall.train.member.mapper.MemberMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;
    public int count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    public long register(String mobile) {
        MemberExample example = new MemberExample();
        example.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(example);
        if(CollUtil.isNotEmpty(list)) {
//            return list.get(0).getId();
            throw new RuntimeException("该手机号已经注册过");
        }

        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }
}
