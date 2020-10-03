package com.example.docker.controller;

import com.example.docker.domain.Member;
import com.example.docker.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / mingood92@gmail.com / https://velog.io/@mingood
 * @since 2020. 08. 16.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("member")
public class TestController {

    private final MemberRepository memberRepository;

    // 편의상 GET으로 함
    @GetMapping("/save")
    public void save() {
        memberRepository.save(Member.builder().name("Hardy").build());
    }

    @GetMapping("/get")
    public String get() {
        return memberRepository.findAll().toString();
    }

}
