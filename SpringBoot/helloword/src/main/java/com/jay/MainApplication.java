package com.jay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主程序类
 * @author Administrator
 * @SpringBootApplication： 这是一个SpringBoot应用
 * scanBasePackages: 改变扫描路径
 * */

@SpringBootApplication(scanBasePackages = "com.jay")
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
