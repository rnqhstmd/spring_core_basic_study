package com.basic.basiccore.discount;

import com.basic.basiccore.member.domain.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
