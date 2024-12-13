package com.basic.basiccore.common.config;

import com.basic.basiccore.discount.DiscountPolicy;
import com.basic.basiccore.discount.RateDiscountPolicy;
import com.basic.basiccore.member.domain.repository.MemberRepository;
import com.basic.basiccore.member.domain.repository.MemoryMemberRepository;
import com.basic.basiccore.member.service.MemberService;
import com.basic.basiccore.member.service.MemberServiceImpl;
import com.basic.basiccore.order.service.OrderService;
import com.basic.basiccore.order.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 설정을 구성한다는 뜻의 어노테이션
@Configuration
public class AppConfig {

    // 생성자 주입 방식
    // 애플리케이션의 실제 동작에 필요한 구현 객체를 생성하고, 생성한 객체 인스턴스의 참조를 생성자를 통해서 주입(연결)해준다.

    // MemberServiceImpl은 MemberRepository인 추상에만 의존하면 된다. 이제 구체 클래스를 몰라도 됨! -> DIP 충족

    // appConfig 객체는 memoryMemberRepository 객체를 생성하고 그 참조값을 memberRepositoryImpl을 생성하면서 생성자로 전달한다.
    // 클라이언트인 memberServiceImpl 입장에서 보면 의존관계를 마치 외부에서 주입해주는 것 같다고 해서 DI, Dependency Injection 의존관계 주입이라고 한다.
    @Bean // 이 어노테이션을 통해 스프링 컨테이너에 스프링 빈으로 등록할 수 있다.
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                discountPolicy(),
                memberRepository()
        );
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // 이제 할인 정책을 변경해도 구성역할을 담당하는 AppConfig 코드만 수정하면 된다.
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();

    }
}
