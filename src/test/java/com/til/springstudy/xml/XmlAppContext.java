package com.til.springstudy.xml;


import com.til.springstudy.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
public class XmlAppContext {
    @Test
    void xmlAppContext(){
        ApplicationContext applicationContext = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = applicationContext.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
