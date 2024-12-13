package com.basic.basiccore;

import com.basic.basiccore.common.config.AppConfig;
import com.basic.basiccore.member.domain.Grade;
import com.basic.basiccore.member.domain.Member;
import com.basic.basiccore.member.service.MemberService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService()

        // ApplicationContext를 스프링 컨테이너라고 한다. 스프링 컨테이너는 @Configuation이 붙은 AppConfig를 설정 정보로 사용한다.
        // 여기서 @Bean이라고 적힌 메서드를 모두 호출하여 반환된 객체를 스프링 컨테이너에 등록한다. 이렇게 등록된 객체들을 스프링 빈이라고 하는 것!
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 이전에는 AppConfig를 사용해서 필요한 객체를 찾았지만, 이젠 스프링 컨테이너를 통해서 필요한 스프링 빈(객체)를 찾아야한다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}

