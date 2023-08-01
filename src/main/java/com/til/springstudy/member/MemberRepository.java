package com.til.springstudy.member;


public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);


}
