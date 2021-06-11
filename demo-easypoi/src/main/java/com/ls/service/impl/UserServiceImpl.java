package com.ls.service.impl;


import com.ls.mapper.UserTabMapper;
import com.ls.pojo.UserTab;
import com.ls.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserTabMapper userTabMapper;
    @Override
    public List<UserTab> findAll() {
        List<UserTab> users = userTabMapper.selectList(null);
        return  users;

    }
}
