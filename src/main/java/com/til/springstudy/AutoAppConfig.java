package com.til.springstudy;

import com.til.springstudy.member.MemberRepository;
import com.til.springstudy.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan // @Component 가 붙은 어노테이션을 찾아서 다 스프링 컨테이너에 자동 등록
        (
                basePackages = "com.til.springstudy", // 어디서 부터 찾을지 설정가능
                basePackageClasses = AutoAppConfig.class, // default = 현재 클래스의 패키지부터 하위 전부 스캔
                excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
                    Configuration.class
                })
        )
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
