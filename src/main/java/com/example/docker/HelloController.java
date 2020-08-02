package com.example.docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / mingood92@gmail.com / https://velog.io/@mingood
 * @since 2020. 08. 02.
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("/docker")
    public String hello() {
        return "Hello, Docker";
    }

}
