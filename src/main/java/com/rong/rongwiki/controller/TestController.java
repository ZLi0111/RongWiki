package com.rong.rongwiki.controller;

import com.rong.rongwiki.domain.Test;
import com.rong.rongwiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {
    @Value("${test.hello:Test}")
    private String testHello;

    @Resource
    private TestService testService;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!" + testHello;
    }

    @RequestMapping("/hello/post")
    public String helloPost(String name) {
        return "Hello World!" + name;
    }

    @GetMapping("/test/list")
    public List<Test> list() {
        return testService.list();
    }
}
