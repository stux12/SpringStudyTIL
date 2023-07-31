package com.til.springstudy.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

// 단점 스프링에 너무 의존적이게 됨
public class NetworkClient3 {

    private String url;

    public NetworkClient3() {
        System.out.println("생성자 호출, url = " + url);
//        connect();
//        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){
        System.out.println("call = " + url + " message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect(){
        System.out.println("close: " + url);
    }

    // 의존관계 주입이 끝나면 호출
    @PostConstruct // javax 애노테이션이며 권장하는 방법
    public void init()  {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close()  {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
