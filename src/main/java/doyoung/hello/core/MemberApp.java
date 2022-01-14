package doyoung.hello.core;

import doyoung.hello.core.member.Grade;
import doyoung.hello.core.member.Member;
import doyoung.hello.core.member.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    private static final Logger logger = LoggerFactory.getLogger(MemberApp.class);

    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        final Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        final Member findMember = memberService.findMember(1L);
        logger.info("new member = {}", member.getName());
        logger.info("find member = {}", findMember.getName());
    }
}
