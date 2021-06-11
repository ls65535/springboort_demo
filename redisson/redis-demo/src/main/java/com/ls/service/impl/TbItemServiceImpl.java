package com.ls.service.impl;

import com.ls.config.RedisSonUtils;
import com.ls.config.RedisUtil;
import com.ls.mapper.TbItemMapper;
import com.ls.pojo.TbItem;
import com.ls.service.TbItemService;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ls on 2020/3/12.
 */
@Service

public class TbItemServiceImpl implements TbItemService {

    private final Logger logger = LoggerFactory.getLogger(TbItemServiceImpl.class);

    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private RedisSonUtils redisSonUtils;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 库存  不能使用 volatile不保证对变量操作的原子性
     */
   //private volatile Integer stockNum;


    @Override
    public List<TbItem> queryAll() {
        List<TbItem> tbItemList = tbItemMapper.selectList();
        logger.info("tbItemList{}" + tbItemList);
        return tbItemList;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean killItemV4(Long killId, Integer buyNum) throws Exception {
          Integer stockNum;
        Boolean result = false;
        String keyId = String.valueOf(killId);
        final String lockKey = new StringBuffer().append(killId).append("-RedisSonLock").toString();
        RLock lock = redisSonUtils.getRLock(lockKey);

        try {
            /**
             * 第一个参数30s=表示尝试获取分布式锁，并且最大的等待获取锁的时间为30s
             * 第二个参数10s=表示上锁之后，10s内操作完毕将自动释放锁
             */
            Boolean cacheRes = lock.tryLock(30, 10, TimeUnit.SECONDS);
            if (cacheRes) {
                //TODO:核心业务逻辑的处理
                //先从redis查库存
                stockNum = (Integer) redisUtil.get(keyId);
                logger.info("redis库存：" + stockNum);
                if (stockNum == null) {
                    TbItem dbTbItem = tbItemMapper.selectByPrimaryKey(killId);
                    stockNum = dbTbItem.getNum();
                    redisUtil.set(keyId, stockNum);
                }
                if (stockNum <= 0) {
                    throw new Exception("库存不足01!");
                }
                if (stockNum >= 0) {
                    //先更新redis库存
                    Long kcNum = redisUtil.decr(keyId, buyNum);
                    logger.info("redis剩余库存：" + kcNum);
                    stockNum -= buyNum;
                    if (kcNum.intValue() != stockNum) {
                        throw new Exception("系统错误!");
                    }
                    TbItem tbItem = new TbItem();
                    tbItem.setId(killId);
                    tbItem.setNum(stockNum);
                    tbItem.setUpdated(new Date());
                    //更新数据库库存
                    int res = tbItemMapper.updateByPrimaryKeySelective(tbItem);
                    if (res > 0 && stockNum >= 0) {
                        logger.info("购买成功");
                        result = true;
                    }
                }
            }

        } finally {
            //TODO:释放锁
            lock.unlock();
        }
        return result;

    }


}
