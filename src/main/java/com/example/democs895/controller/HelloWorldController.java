package com.example.democs895.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class HelloWorldController {
    
    @RequestMapping(value="/{name}",method= RequestMethod.GET)
    public String sayHi(@PathVariable String name){
        return "Hello "+name;
    }
    
}
