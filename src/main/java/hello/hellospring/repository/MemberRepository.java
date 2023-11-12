package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원 저장


    //회원 조회
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);

    //모든 회원 반환
    List<Member> findAll();


}
