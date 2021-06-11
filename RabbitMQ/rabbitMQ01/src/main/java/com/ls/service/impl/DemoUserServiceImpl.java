package com.ls.service.impl;

import com.ls.mapper.DemoUserMapper;
import com.ls.pojo.DemoUser;
import com.ls.service.DemoUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ls on 2019/6/26.
 */
@Service
public class DemoUserServiceImpl implements DemoUserService {
    @Autowired
    private DemoUserMapper demoUserMapper;

    @Override
    public List<DemoUser> queryAll() {
        List<DemoUser> demoUsers = demoUserMapper.selectList(null);

        return demoUsers;
    }
}
