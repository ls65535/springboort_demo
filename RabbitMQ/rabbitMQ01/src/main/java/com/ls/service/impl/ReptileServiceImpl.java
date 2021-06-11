package com.ls.service.impl;

import com.alibaba.fastjson.JSON;
import com.ls.pojo.Reptile;
import com.ls.rabbitmq.producer.ProducerSender;
import com.ls.service.ReptileService;
import com.ls.utils.GetJsonUtil;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ls on 2019/10/31.
 */
@Service
public class ReptileServiceImpl implements ReptileService {

    @Autowired
    private ProducerSender producerSender;
    @Override
    public Boolean getData() {
        int start;//每页多少条
        int total = 0;//记录数
        int end = 100;//总共9979条数据
        for (start = 0; start <= end; start += 20) {
            String address = "https://Movie.douban.com/j/new_search_subjects?sort=U&range=0,10&tags=&start=" + start;

            try {
                JSONObject dayLine = new GetJsonUtil().getHttpJson(address, 1);

                System.out.println("start:" + start);
                JSONArray json = dayLine.getJSONArray("data");
                String uuid = UUID.randomUUID().toString();
                List<Reptile> list = JSON.parseArray(json.toString(), Reptile.class);
                producerSender.sendMessage(uuid,list);

                if (start <= end) {
                    System.out.println("已经爬取到底了");
                }
                total += list.size();
                System.out.println("正在爬取中---共抓取:" + total + "条数据");

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return true;
    }
}