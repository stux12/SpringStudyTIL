package com.til.springstudy.discount;

import com.til.springstudy.member.Grade;
import com.til.springstudy.member.Member;

public class FixDiscountPolicy implements DisCountPolicy{

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            // 1000원 할인
            return 1000;
        }else{
            return 0;
        }
    }
}
