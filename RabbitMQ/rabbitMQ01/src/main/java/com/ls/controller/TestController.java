package com.ls.controller;

import com.ls.rabbitmq.producer.ProducerSender;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ProducerSender producerSender;

    @PostMapping("/send")
    @ApiOperation(value = "发送消息", tags = {"rabbitmq"})
    public String send(@ApiParam(value = "消息", required = true) @RequestBody String message) {
        String uuid = UUID.randomUUID().toString();
        producerSender.sendMessage(uuid, message);
        return uuid;
    }


}
