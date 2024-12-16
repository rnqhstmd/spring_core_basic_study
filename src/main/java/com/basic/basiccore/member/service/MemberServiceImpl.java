package com.basic.basiccore.member.service;

import com.basic.basiccore.member.domain.Member;
import com.basic.basiccore.member.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 컴포넌트 스캔의 대상이 되도록 @Component 붙이기
public class MemberServiceImpl implements MemberService {

    // 이렇게되니 의존관계가 인터페이스 뿐만 아니라 구현까지 모두 의존하는 문제점이 있다.
    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;

    @Autowired // 의존관계를 자동으로 주입해준다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
