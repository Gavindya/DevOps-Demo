package com.example.democs895.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("request")
public class GreetingController {

    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String helloFunc(){
        return "Hello, Stranger!";
    }
}
