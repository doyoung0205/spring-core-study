package doyoung.hello.core;

import doyoung.hello.core.discount.DiscountPolicy;
import doyoung.hello.core.discount.RateDiscountPolicy;
import doyoung.hello.core.member.MemberRepository;
import doyoung.hello.core.member.MemberService;
import doyoung.hello.core.member.MemberServiceImpl;
import doyoung.hello.core.member.infra.MemoryMemberRepository;
import doyoung.hello.core.order.OrderService;
import doyoung.hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
