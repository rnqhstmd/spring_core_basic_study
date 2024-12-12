package com.basic.basiccore.member.domain.repository;

import com.basic.basiccore.member.domain.Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    // 여기선 동시성 이슈로 실무에선 ConcurrentHashMap 을 쓰는 게 맞다. 여기선 예제니까 HashMap 을 사용
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
