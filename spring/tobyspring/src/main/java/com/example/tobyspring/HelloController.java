package com.example.tobyspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author love_
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(String name) {
        return "Hello " + name;
    }
}
