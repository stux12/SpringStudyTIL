package com.til.springstudy.autowired;

import com.til.springstudy.AutoAppConfig;
import com.til.springstudy.discount.DisCountPolicy;
import com.til.springstudy.member.Grade;
import com.til.springstudy.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class);
        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountService.discount(member, 10000, "fixDiscountPolicy");

        Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
        Assertions.assertThat(discountPrice).isEqualTo(1000);

        int rateDiscountPrice = discountService.discount(member, 20000, "rateDiscountPolicy");
        Assertions.assertThat(rateDiscountPrice).isEqualTo(2000);
    }

    static class DiscountService{
        private final Map<String, DisCountPolicy> policyMap;
        private final List<DisCountPolicy> policies;

        @Autowired
        public DiscountService(Map<String, DisCountPolicy> policyMap, List<DisCountPolicy> policies){
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int count, String discountCode) {
            DisCountPolicy disCountPolicy = policyMap.get(discountCode);
            return disCountPolicy.discount(member, count);
        }
    }
}
