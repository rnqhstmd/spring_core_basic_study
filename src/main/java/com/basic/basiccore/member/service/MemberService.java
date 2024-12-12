package com.basic.basiccore.member.service;

import com.basic.basiccore.member.domain.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
