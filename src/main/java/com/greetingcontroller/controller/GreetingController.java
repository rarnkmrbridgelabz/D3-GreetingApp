package com.greetingcontroller.controller;

import com.greetingcontroller.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/welcome")
public class GreetingController {

    private static final String TEMPLATE = "Hello,%s";
    private static final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = {"", "/", "/home"}, method = RequestMethod.GET)
    public User greeting(@RequestParam(value = "name", defaultValue = "Bridgelabz") String name) {
        return new User(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }
}
