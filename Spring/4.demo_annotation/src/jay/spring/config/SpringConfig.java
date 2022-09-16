package jay.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // 最为配置类，替代配文件
@ComponentScan(basePackages = "jay.spring")    // 等价于 <context:component-scan base-package="jay.spring" use-default-filters="false">
public class SpringConfig {

}
