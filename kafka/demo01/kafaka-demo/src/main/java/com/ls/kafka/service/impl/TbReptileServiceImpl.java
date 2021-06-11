package com.ls.kafka.service.impl;

import com.alibaba.fastjson.JSON;
import com.ls.kafka.entity.TbReptile;
import com.ls.kafka.producer.KafkaProducer;
import com.ls.kafka.service.TbReptileService;
import com.ls.utils.GetJsonUtil;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-11-01
 */
@Service
public class TbReptileServiceImpl implements TbReptileService {

    private final static String topic = "test01";
    @Autowired
    private KafkaProducer kafkaProducer;

    @Override
    public Boolean getDouBanMovieData() {

        int start;//每页多少条
        int total = 0;//记录数
        int end = 200;//总共9979条数据
        for (start = 0; start <= end; start += 20) {
            String address = "https://Movie.douban.com/j/new_search_subjects?sort=U&range=0,10&tags=&start=" + start;

            try {
                JSONObject dayLine = new GetJsonUtil().getHttpJson(address, 1);

                System.out.println("start:" + start);
                JSONArray json = dayLine.getJSONArray("data");
                String data = json.toString();
                kafkaProducer.sendMessage(topic, data);
                if (start <= end) {
                    System.out.println("已经爬取到底了");
                }
                System.out.println("正在爬取中---共抓取:" + total + "条数据");

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return true;
    }


}