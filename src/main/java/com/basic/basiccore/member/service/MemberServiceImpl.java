package com.basic.basiccore.member.service;

import com.basic.basiccore.member.domain.Member;
import com.basic.basiccore.member.domain.repository.MemberRepository;
import com.basic.basiccore.member.domain.repository.MemoryMemberRepository;

public class MemberServiceImpl implements MemberService {

    // 이렇게되니 의존관계가 인터페이스 뿐만 아니라 구현까지 모두 의존하는 문제점이 있다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
