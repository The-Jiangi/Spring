package com.jay.config;

import ch.qos.logback.core.boolex.Matcher;
import com.jay.bean.Car;
import com.jay.bean.Pet;
import com.jay.bean.User;
import com.mysql.cj.util.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Administrator
 * @Configuration： 告诉SpringBoot 这是一个配置类(容器)
 * 1、配置类里面使用 @Bean标注在方法上给容器注册组件，默认是单实例
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods：将组件改为多实例对象
 * <p>
 * 4、@Import({User.class, Matcher.class})
 * 给容器中自动创建出这两个类型的组件，默认名为类的名字
 * <p>
 * 5、@Conditional   条件装配 (注意组件注册的先后顺序)
 * @ConditionalOnBean(name="tom")： 容器中存在tom组件才生效
 * @ConditionalOnMissingBean(name="tom")： 容器中没有tom组件才生效
 * <p>
 * 6、@ImportResource("classpath:bean.xml") 导入Spring的配置文件
 * <p>
 * 7、@EnableConfigurationProperties(Car.class) （第三方库没有@Component时使用）
 * 1.开启 Car配置绑定功能（使用application.properties配置属性）
 * 2.把这个 Car组件自动注册到容器中
 */

@Import({User.class, Matcher.class})
@Configuration(proxyBeanMethods = false)
@ConditionalOnMissingBean(name = "user01")
@ImportResource("classpath:bean.xml")
@EnableConfigurationProperties(Car.class)
public class MyConfig {

    /**
     * 在容器中添加组件
     */
    @Bean
    public User user01() {
        return new User("zhangsan", 18);
    }

    @Bean("tom")
    public Pet catPet() {
        return new Pet("tomcat", 5);
    }

    /**
     * WebMvcConfigurer定制化SpringMVC的功能
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {

            /** 功能1、将上传的 pet="阿猫,3" 转换为 pet.name="阿猫";pet.age="3" */
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        // source = "阿猫,3"
                        if (!StringUtils.isNullOrEmpty(source)) {  // 如果source不为空
                            Pet pet = new Pet();
                            String[] split = source.split(",");
                            pet.setName(split[0]);
                            pet.setAge(Integer.parseInt(split[1]));
                            return pet;
                        }
                        return null;
                    }
                });
            }

            /** 功能2 */

        };
    }
}
