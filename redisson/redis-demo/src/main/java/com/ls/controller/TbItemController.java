package com.ls.controller;

import com.ls.pojo.TbItem;
import com.ls.service.TbItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ls on 2020/3/12.
 */
@RestController
public class TbItemController {

    @Autowired
    private TbItemService tbItemService;

    @GetMapping("/queryAll")
    public List<TbItem> queryAll(){
        List<TbItem> tbItemList= tbItemService.queryAll();
        return tbItemList;
    }
    @GetMapping("/killItemV4")
    public Boolean killItemV4(Long id,Integer num)throws Exception{
        Boolean flag= tbItemService.killItemV4(id,num);
        return flag;
    }


}
