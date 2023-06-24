package com.til.springstudy.beanFind;

import com.til.springstudy.member.MemberRepository;
import com.til.springstudy.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다")
    void findBeanByTypeDuplicate(){
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> applicationContext.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("특정 타입 하나만 조회하기")
    void findBeanByName(){
        MemberRepository memberRepository = applicationContext.getBean("memberRepository1",MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findAllBeanByType(){
        Map<String, MemberRepository> beansOfType = applicationContext.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }
    @Configuration
    static class SameBeanConfig {

        @Bean
//        @Primary Primary 선언 시 같은 Bean Name 이 있을 때 우선적으로 적용이 됨
        public MemberRepository memberRepository1 () {
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2 () {
            return new MemoryMemberRepository();
        }
    }
}
