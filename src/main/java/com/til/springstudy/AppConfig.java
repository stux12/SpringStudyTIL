package com.til.springstudy;

import com.til.springstudy.discount.DisCountPolicy;
import com.til.springstudy.discount.RateDiscountPolicy;
import com.til.springstudy.member.MemberRepository;
import com.til.springstudy.member.MemberService;
import com.til.springstudy.member.MemberServiceImpl;
import com.til.springstudy.member.MemoryMemberRepository;
import com.til.springstudy.order.OrderService;
import com.til.springstudy.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(getMemoryMemberRepository());
    }

    public MemberRepository getMemoryMemberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(getMemoryMemberRepository(), getFixDiscountPolicy());
    }

    public DisCountPolicy getFixDiscountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
