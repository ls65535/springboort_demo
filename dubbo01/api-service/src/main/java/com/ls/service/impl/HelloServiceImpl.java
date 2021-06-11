package com.ls.service.impl;


import com.ls.service.HelloService;
import org.apache.dubbo.config.annotation.Service;


@Service //注意是dubbo的service依赖
public class HelloServiceImpl  implements HelloService {

    @Override
    public String sayHello(String name) {
        return name+"我是提供者";
    }
}
