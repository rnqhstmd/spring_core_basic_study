package com.basic.basiccore.discount;

import com.basic.basiccore.common.annotation.MainDiscountPolicy;
import com.basic.basiccore.member.domain.Grade;
import com.basic.basiccore.member.domain.Member;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
