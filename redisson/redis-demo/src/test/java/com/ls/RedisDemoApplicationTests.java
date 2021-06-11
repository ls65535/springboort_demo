package com.ls;

import com.ls.service.TbItemService;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedisDemoApplicationTests {

    @Autowired
    private TbItemService tbItemService;


    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void test02(){
        RLock disLock = redissonClient.getLock("DISLOCK");
        boolean isLock;
        try {
            //尝试获取分布式锁
            isLock = disLock.tryLock(500, 15000, TimeUnit.MILLISECONDS);
            if (isLock) {
                //TODO if get lock success, do something;
                System.out.println("11111");
                //Thread.sleep(15000);
            }
        } catch (Exception e) {
        } finally {
            // 无论如何, 最后都要解锁
            disLock.unlock();
        }
    }
    @Test
    public void test() {
        try {

            //需求数量
            int requireQty = 9;
            for (int i = 0; i < 30; i++) {
                Thread t = new Thread(() -> {
                    try {

                        RLock rLock = redissonClient.getLock("myLock");
                        System.out.println(Thread.currentThread().getName() + "开始");
                        RAtomicLong stockQty = redissonClient.getAtomicLong("stockQty");
                        RAtomicLong stockOccupy = redissonClient.getAtomicLong("stockOccupy");
                        rLock.lock();
                        long l1 = stockQty.get();
                        long l2 = stockOccupy.get();
                        long l = l1 - l2;
                        System.out.println(Thread.currentThread().getName() + "获得锁");
                        System.out.println(Thread.currentThread().getName() + "do something");
                        if (l >= requireQty) {
                            stockOccupy.set(stockOccupy.get() + requireQty);
                        }
                        rLock.unlock();
                        //创建订单，扣减库存
                        Thread.sleep(200);
                        if (l >= requireQty) {
                            System.out.println(Thread.currentThread().getName() + "done，库存剩下：" + l);
                        } else {
                            System.out.println(Thread.currentThread().getName() + "库存不足，库存剩下：" + l);
                        }
                        // System.out.println(Thread.currentThread().getName() + "准备释放锁");
                        System.out.println(Thread.currentThread().getName() + "结束");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }

                });
                t.start();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {

        }
    }

}
