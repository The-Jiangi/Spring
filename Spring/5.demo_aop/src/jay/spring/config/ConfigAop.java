package jay.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration  // 完全注解方式
@ComponentScan(basePackages = {"jay.spring"})   // 开启注解扫描
@EnableAspectJAutoProxy(proxyTargetClass = true)    // 生成代理对象
public class ConfigAop {

}
