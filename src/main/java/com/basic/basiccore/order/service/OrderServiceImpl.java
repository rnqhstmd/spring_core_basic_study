package com.basic.basiccore.order.service;

import com.basic.basiccore.discount.DiscountPolicy;
import com.basic.basiccore.member.domain.Member;
import com.basic.basiccore.member.domain.repository.MemberRepository;
import com.basic.basiccore.order.domain.Order;

public class OrderServiceImpl implements OrderService {


    // DIP 위반 : 할인정책을 변경하려면 매번 이렇게 클래스 의존관계를 수정해야한다. -> 지금 인터페이스뿐만 아니라 구현클래스에 의존하고 있다.
    // OCP 위반 : 변경하지않고 확장할 수 있어야하지만, 현재 구현클래스를 수정해야하기에 OCP를 위반했다. 차를 바꿨다고 면허도 바꿔야하는 것과 같다.
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;

    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
