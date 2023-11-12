package hello.hellospring.service;

import hello.hellospring.domain.Member;


import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class MemberServiceTest {

    MemberService memberService;

    MemoryMemberRepository memberRepository;

    //테스트 하나 실행할때마다, 동작하기전에 실행
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    //테스트 하나 끝날때마다 실행
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();

    }


    @Test //Test코드는 join->회원 가입 으로 한국어로 쉽게 적어도됨!
    void 회원가입() {
        //given 이런데이터가 주어졌을때
        Member member = new Member();
        member.setName("hello");

        //when 이거를 실행했을때
        Long saveId = memberService.join(member);

        //then 결과가 이게 나와야해
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");


        //when+ then , 중복회원이면 IllegalStateException 예외가 터질 것임
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}