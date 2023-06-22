package com.til.springstudy.order;

import com.til.springstudy.discount.DisCountPolicy;
import com.til.springstudy.discount.FixDiscountPolicy;
import com.til.springstudy.member.Member;
import com.til.springstudy.member.MemberRepository;
import com.til.springstudy.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DisCountPolicy disCountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = disCountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
