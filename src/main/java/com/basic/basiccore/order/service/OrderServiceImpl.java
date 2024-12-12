package com.basic.basiccore.order.service;

import com.basic.basiccore.discount.DiscountPolicy;
import com.basic.basiccore.discount.FixDiscountPolicy;
import com.basic.basiccore.member.domain.Member;
import com.basic.basiccore.member.domain.repository.MemberRepository;
import com.basic.basiccore.member.domain.repository.MemoryMemberRepository;
import com.basic.basiccore.order.domain.Order;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
