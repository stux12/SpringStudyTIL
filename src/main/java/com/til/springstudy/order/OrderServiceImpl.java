package com.til.springstudy.order;

import com.til.springstudy.discount.DisCountPolicy;
import com.til.springstudy.member.Member;
import com.til.springstudy.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // final 붙은 값을 가지고 생성자를 만들어줌
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DisCountPolicy disCountPolicy;

    // @RequiredArgsConstructor 로 생략가능
//    public OrderServiceImpl(MemberRepository memberRepository, DisCountPolicy disCountPolicy) {
//        this.memberRepository = memberRepository;
//        this.disCountPolicy = disCountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        System.out.println("member = " + member);
        int discountPrice = disCountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
