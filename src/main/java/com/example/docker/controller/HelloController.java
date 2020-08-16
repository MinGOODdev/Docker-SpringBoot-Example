package com.example.docker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / mingood92@gmail.com / https://velog.io/@mingood
 * @since 2020. 08. 02.
 */
@RestController
public class HelloController {

    @Value("${active.value}")
    private String activeValue;

    @GetMapping("/")
    public String helloDocker() {
        return "Hello, Docker : " + activeValue;
    }

}
