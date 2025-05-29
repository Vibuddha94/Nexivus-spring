package com.VibutsX.NexivusSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



    @RestController
public class HelloController {
    @GetMapping("/hello")
    public String getMethodName() {
        String hello = "Hello Nexivus Gen 2";
        return hello;
    }
}