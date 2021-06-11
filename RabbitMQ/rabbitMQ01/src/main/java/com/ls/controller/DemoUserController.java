package com.ls.controller;

import com.ls.pojo.DemoUser;
import com.ls.service.DemoUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ls on 2019/6/26.
 */
@RestController
@RequestMapping("/user")
public class DemoUserController {
    @Autowired
    private DemoUserService demoUserService;


    @GetMapping("/queryAll")
    public List<DemoUser> queryAll(){
        List<DemoUser> demoUsers = demoUserService.queryAll();
        return demoUsers;
    }

}
