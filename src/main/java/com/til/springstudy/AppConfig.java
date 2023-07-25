package com.til.springstudy;

import com.til.springstudy.discount.DisCountPolicy;
import com.til.springstudy.discount.RateDiscountPolicy;
import com.til.springstudy.member.MemberRepository;
import com.til.springstudy.member.MemberService;
import com.til.springstudy.member.MemberServiceImpl;
import com.til.springstudy.member.MemoryMemberRepository;
import com.til.springstudy.order.OrderService;
import com.til.springstudy.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
* Annotation Config 라는 걸 명시해주면서 컨테이너에 등록*/
@Configuration
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()

    /** Spring 컨테이너에 Bean 생성 */
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), getFixDiscountPolicy());
    }

    @Bean
    public DisCountPolicy getFixDiscountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
