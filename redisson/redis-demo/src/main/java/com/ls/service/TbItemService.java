package com.ls.service;

import com.ls.pojo.TbItem;
import java.util.List;

/**
 * Created by ls on 2020/3/12.
 */
public interface TbItemService {

    List<TbItem> queryAll();



    /**
     * 模拟秒杀系统
     * @param killId
     * @param buyNum
     * @return
     * @throws Exception
     */
   Boolean killItemV4(Long killId, Integer buyNum) throws Exception;


}
