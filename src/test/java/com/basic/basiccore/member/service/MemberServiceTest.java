package com.basic.basiccore.member.service;

import com.basic.basiccore.member.domain.Grade;
import com.basic.basiccore.member.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl(null);

    @Test
    void join() {

        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }

    @Test
    void findMember() {
    }
}