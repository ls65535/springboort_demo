package com.ls.kafka.producer;

import com.ls.comon.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by ls on 2019/10/23.
 */
@Component //这个必须加入容器不然，不会执行
public class KafkaProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String topic,Object data){
        if(StringUtils.isEmpty(topic)){
            throw new ServiceException("9001","topic不能为空");
        }
        if(StringUtils.isEmpty(data)){
            throw new ServiceException("9002","发送数据data不能为空");
        }
        kafkaTemplate.send(topic,data);
        //发送方式很多种可以自己研究一下
    }
}
