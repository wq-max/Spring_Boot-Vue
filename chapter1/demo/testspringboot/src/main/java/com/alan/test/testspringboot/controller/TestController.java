package com.alan.test.testspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("test")
    public void test(){
        System.out.println("Hello World");
    }
}