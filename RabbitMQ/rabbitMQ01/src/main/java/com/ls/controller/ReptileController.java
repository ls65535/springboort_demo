package com.ls.controller;

import com.ls.service.ReptileService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ls on 2019/10/31.
 */
@RestController
@RequestMapping("/reptile")
public class ReptileController {

    @Autowired
    private ReptileService reptileService;
    @GetMapping
    @ApiOperation(value = "爬取豆瓣电影的数据",tags = {"reptile"})
    public Boolean douBan(){
        Boolean data = reptileService.getData();
        return data;
    }
}
