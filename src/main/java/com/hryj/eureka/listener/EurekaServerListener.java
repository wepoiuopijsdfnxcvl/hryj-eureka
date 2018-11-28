package com.hryj.eureka.listener;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.netflix.appinfo.InstanceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 李道云
 * @className: EurekaServerListener
 * @description: eureka注册中心服务监听
 * @create 2018-06-23 13:30
 **/
@Component
public class EurekaServerListener {

    private final static Logger log = LoggerFactory.getLogger(EurekaServerListener.class);

    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        log.info(DateUtil.format(new Date(event.getTimestamp()), DatePattern.NORM_DATETIME_MS_PATTERN) + "\t" + "注册中心启动");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        log.info(DateUtil.format(new Date(event.getTimestamp()),DatePattern.NORM_DATETIME_MS_PATTERN) + "\t" + "Eureka Server 启动");
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        log.info(DateUtil.format(new Date(event.getTimestamp()),DatePattern.NORM_DATETIME_MS_PATTERN) + "\t" + instanceInfo.getInstanceId() + "\t" + instanceInfo.getAppName() + " 进行注册");
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        log.info(DateUtil.format(new Date(event.getTimestamp()),DatePattern.NORM_DATETIME_MS_PATTERN) + "\t" + event.getServerId() + "\t" + event.getAppName() + " 服务进行续约");
    }

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        log.info(DateUtil.format(new Date(event.getTimestamp()),DatePattern.NORM_DATETIME_MS_PATTERN) + "\t" + event.getServerId() + "\t" + event.getAppName() + " 服务下线");
    }
}
