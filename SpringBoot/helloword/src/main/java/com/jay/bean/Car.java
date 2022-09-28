package com.jay.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @Component： 定义为容器，只有容器中的组件，才会拥有SpringBoot提供的强大功能
 */
@Data   // lombok简化开发 == get/set方法
@ToString   // lombok简化开发  == toString开发
// @Component
@ConfigurationProperties(prefix = "mycar")
public class Car {

    private String brand;
    private Integer price;
}
