package com.til.springstudy.discount;

import com.til.springstudy.member.Member;

public interface DisCountPolicy {

    /**
     * @param member 멤버
     * @param price 가격
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
