package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        //반환값이 Null일 가능성이 있을때 쓰는게 Optional.ofNullable()
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                    .filter(member -> member.getName().equals(name))
                    .findAny();
    }


    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    //테스트 할때, 하나 테스트 끝나면 저장소나, 공용데이터 지우는 역할함
    public void clearStore() {
        store.clear();
    }
}
