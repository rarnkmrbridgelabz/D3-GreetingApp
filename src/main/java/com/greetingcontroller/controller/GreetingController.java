package com.greetingcontroller.controller;

import com.greetingcontroller.entity.User;
import com.greetingcontroller.service.GreetingAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/welcome")
public class GreetingController {

    private static final String TEMPLATE = "Hello,%s";
    private static final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingAppService greetingAppService;

    @RequestMapping(value = {"", "/", "/home"}, method = RequestMethod.GET)
    public User greeting(@RequestParam(value = "name", defaultValue = "Bridgelabz") String name) {
        return new User(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }
    @GetMapping("/get")
    public User sayHello() {
        return greetingAppService.getMessage();
    }
}
