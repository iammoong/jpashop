package jpabook.jpashop;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    public void testMember () throws Exception {

        Member member = new Member();
        member.setUsername("memberA");

        Long savedId =  memberRepository.save(member);

        Member findMember = memberRepository.find(savedId);

        Assertions.assertEquals(member.getUsername(), findMember.getUsername());
        Assertions.assertEquals(member.getId(), findMember.getId());
    }
}