package com.ls.controller;


import com.ls.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    @Reference
    private HelloService helloService;
    @GetMapping("/test")
    public String test(String name){
        String s = helloService.sayHello(name);
        return s;
    }
}
