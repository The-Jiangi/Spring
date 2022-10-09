package com.jay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类
 *
 * @author Administrator
 * @SpringBootApplication： 这是一个SpringBoot应用
 * scanBasePackages: 改变扫描路径
 */

@SpringBootApplication(scanBasePackages = "com.jay")
public class MainApplication {
    public static void main(String[] args) {
        // 1、返回我们的IOC容器
        ConfigurableApplicationContext run =
                SpringApplication.run(MainApplication.class, args);


        int min =  845+18+11+23+28+39;
        int sec = 1523+ 7+37+29+ 3+55;
        System.out.println(min + (sec / 60));
    }
}
