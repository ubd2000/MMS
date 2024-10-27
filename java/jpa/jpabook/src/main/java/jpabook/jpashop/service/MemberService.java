package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author DongMin kim
 */
@Service
@RequiredArgsConstructor
public class MemberService {

    //변경 될 일이 없기 때문에 final로 선언
    //compile 시점에 memberRepository가 주입이 되지 않으면 에러가 발생하여 런타임 시점에 오류를 잡을 수 있다.
    private final MemberRepository memberRepository;

    /*
    //setter injection(필드 주입)을 사용하면 테스트 코드 작성시에 mock 객체를 주입하기 쉬워진다.
    //가짜 Repository를 만들어서 테스트 코드를 작성할 수 있다.
    //다만, Application이 동작하고 있을 때 변경할 일이 거의 없다. (사용 X)
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    */


    //장점 1. 생성자 injection을 사용하면 한번 생성할 때 주입받기 때문에 변경이 불가능하다.
    //장점 2. Test case 작성시에 주입해줘야 해서 테스트 코드 작성시에 빼먹는 실수를 방지할 수 있다.
    //최신 Spring boot에서는 생성자가 하나만 있을 경우 @Autowired를 생략해도 된다.
    //다만, @RequiredArgsConstructor를 사용하면 final로 선언된 필드에 대한 생성자를 만들어주는 이 방식을 사용하는 것이 좋다.
    /*public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }*/

    /**
     * 회원 가입
     * @param member
     * @return
     */
    @Transactional
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getUsername());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 회원 전체 조회
     * @return
     */
    @Transactional(readOnly = true) //읽기 전용에는 readOnly = true를 사용하면 성능이 최적화된다.
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 단건 조회
     * @param memberId
     * @return
     */
    @Transactional(readOnly = true)
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
