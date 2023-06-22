package com.til.springstudy;

import com.til.springstudy.discount.FixDiscountPolicy;
import com.til.springstudy.member.MemberService;
import com.til.springstudy.member.MemberServiceImpl;
import com.til.springstudy.member.MemoryMemberRepository;
import com.til.springstudy.order.OrderService;
import com.til.springstudy.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
