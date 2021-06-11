package com.ls.redis;

import com.ls.service.TbItemService;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by ls on 2020/3/13.
 */
@SpringBootTest
public class Redis01AppTest {

    @Autowired
    private TbItemService tbItemService;

    @Autowired
    private RedissonClient redissonClient;
    @Test
    public void  test() throws Exception {
        Boolean aBoolean = tbItemService.killItemV4(18L, 1);
        System.out.println(aBoolean);
    }
}
