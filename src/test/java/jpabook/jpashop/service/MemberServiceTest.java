package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

// Spring 과 관련한 것을 테스트 한다는 것을 Junit 에게 알려준다.
@RunWith(SpringRunner.class)
@SpringBootTest
// Test Code 에서 사용될 때는 Rollback 을 해버린다.
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    /**
     * DB 에 실제 쿼리나 나가는 것을 보고 싶을 경우.
     * 1. @Rollback(false)
     * 2. @Autowired EntityManager em 을 주입받고. insert 문 다음에 flush() 를 호출
     */

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long saveId = memberService.join(member);

        //then
        em.flush();
        assertEquals(member, memberRepository.findOne(saveId));

    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //when
        memberService.join(member1);
        memberService.join(member2); //예외가 발생해야 한다.

//      하단의 코드는 상위 expected 설정으로 대체된다.
//        try {
//            //예외가 발생해야 한다.
//            memberService.join(member2);
//        } catch (IllegalStateException e) {
//            return;
//        }

        //then
        fail("예외가 발생해야 한다.");
    }


}