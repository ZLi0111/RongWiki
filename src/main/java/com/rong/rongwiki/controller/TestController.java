package com.rong.rongwiki.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${test.hello:Test}")
    private String testHello;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!" + testHello;
    }

    @RequestMapping("/hello/post")
    public String helloPost(String name) {
        return "Hello World!" + name;
    }
}
