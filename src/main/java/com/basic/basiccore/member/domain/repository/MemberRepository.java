package com.basic.basiccore.member.domain.repository;

import com.basic.basiccore.member.domain.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
