package doyoung.hello.core.order;

import doyoung.hello.core.AppConfig;
import doyoung.hello.core.member.Grade;
import doyoung.hello.core.member.Member;
import doyoung.hello.core.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderServiceImplTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeAll() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        assertEquals(1000, order.getDiscountPrice());
    }
}
