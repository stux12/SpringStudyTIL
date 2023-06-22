package com.til.springstudy.order;

import com.til.springstudy.discount.DisCountPolicy;
import com.til.springstudy.member.Member;
import com.til.springstudy.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DisCountPolicy disCountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DisCountPolicy disCountPolicy) {
        this.memberRepository = memberRepository;
        this.disCountPolicy = disCountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        System.out.println("member = " + member);
        int discountPrice = disCountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
