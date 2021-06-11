package com.ls.kafka.customer;

import com.alibaba.fastjson.JSON;
import com.ls.kafka.entity.TbReptile;
import com.ls.mapper.kafka.TbReptileMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by ls on 2019/10/23.
 */
@Component
public class KafkaCustomer {

    private final static String topic = "test01";
    /**
     * 豆瓣的消费者
     *
     * @param
     */
    @Autowired
    private TbReptileMapper tbReptileMapper;

    @KafkaListener(topics = {topic})
    public void receive(String message) {
        System.out.println("topic========topic");
        System.out.println(message);
       if(!StringUtils.isEmpty(message)){
           List<TbReptile> list = JSON.parseArray(message, TbReptile.class);
            for (TbReptile tbReptile : list) {
                tbReptileMapper.insert(tbReptile);
            }
        }
    }
}
