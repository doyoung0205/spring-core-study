package doyoung.hello.core.member;

import doyoung.hello.core.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemberServiceImplTest {
    MemberService memberService;

    @BeforeEach
    void beforeAll() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given
        final Member member = new Member(1L, "memberA", Grade.VIP);
        // when
        memberService.join(member);
        // then
        final Member findMember = memberService.findMember(1L);
        assertEquals(member, findMember);
    }

}
