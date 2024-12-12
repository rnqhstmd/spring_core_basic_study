package com.basic.basiccore.order;

import com.basic.basiccore.member.domain.Grade;
import com.basic.basiccore.member.domain.Member;
import com.basic.basiccore.member.service.MemberService;
import com.basic.basiccore.member.service.MemberServiceImpl;
import com.basic.basiccore.order.domain.Order;
import com.basic.basiccore.order.service.OrderService;
import com.basic.basiccore.order.service.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();


    @Test
    void createOrder() {
        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}