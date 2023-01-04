package com.ligong.redis.service;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisService {

    @Autowired
    RedissonClient redissonClient;

    public void hello(){
        RLock lock = redissonClient.getLock("lock");

        try {
            /**
             * waitTime:尝试获取锁的时间，在waitTime时间内，如果没有成功获取锁，会进行锁重试
             * leaseTime：锁的超时释放时间，超过leaseTime时间，锁自动释放，防止死锁
             * 时间单位
             * redisson默认的锁超时释放时间是30s
             */
            lock.tryLock(1L,3L, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
