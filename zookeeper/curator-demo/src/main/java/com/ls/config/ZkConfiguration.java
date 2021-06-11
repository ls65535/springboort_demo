package com.ls.config;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ls on 2020/3/14.
 */
@Configuration
public class ZkConfiguration {

    @Autowired
   private WrapperZk wrapperZk;

    @Bean(initMethod = "start")
    public CuratorFramework curatorFramework() {
        return CuratorFrameworkFactory.newClient(
            wrapperZk.getConnectString(),
            wrapperZk.getSessionTimeoutMs(),
            wrapperZk.getConnectionTimeoutMs(),
            new RetryNTimes(wrapperZk.getRetryCount(), wrapperZk.getElapsedTimeMs()));
    }
}
