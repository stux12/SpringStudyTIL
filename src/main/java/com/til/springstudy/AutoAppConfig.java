package com.til.springstudy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan // @Component 가 붙은 어노테이션을 찾아서 다 스프링 컨테이너에 자동 등록
        (
                excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
                    Configuration.class
                })
        )
public class AutoAppConfig {
}
