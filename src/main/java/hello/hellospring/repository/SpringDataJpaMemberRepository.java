package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JPA spring data를 사용하면, 리포지토리를 겨우 아래 코드 전부르 끝
//직접 개발하던 save등 CRUD기능이 기본적으로 다 내장
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name); //인터페이스 이름만으로도 개발이 끝..
}
