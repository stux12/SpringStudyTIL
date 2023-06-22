package com.til.springstudy.discount;

import com.til.springstudy.member.Grade;
import com.til.springstudy.member.Member;

public class RateDiscountPolicy implements DisCountPolicy{

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            int discountPercent = 10;
            return price * discountPercent / 100;
        }else{
            return 0;
        }
    }
}
