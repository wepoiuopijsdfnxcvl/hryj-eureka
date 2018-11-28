package com.hryj.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 李道云
 * @className: EurekaApplication
 * @description: eureka服务启动
 * @create 2018/6/14 10:13
 **/
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaApplication.class).web(true).run(args);
	}
}
