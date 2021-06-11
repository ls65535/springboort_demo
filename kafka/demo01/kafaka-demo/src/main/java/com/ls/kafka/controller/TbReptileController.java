package com.ls.kafka.controller;


import com.ls.common.BaseController;
import com.ls.comon.response.ResponseJson;
import com.ls.kafka.service.TbReptileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-11-01
 */
@RestController
@RequestMapping("/kafka/tb-reptile")
public class TbReptileController extends BaseController {

    @Autowired
    private TbReptileService reptileService;

    @GetMapping("getDouBanMovie")
    @ApiOperation(value = "爬取豆瓣电影的数据", tags = {"kafka"})
    public ResponseJson<Boolean> getDouBanMovieData() {
        Boolean flag = reptileService.getDouBanMovieData();

        return ResponseJson.ok(flag);
    }

}
