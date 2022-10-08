package com.jay.config;

import com.jay.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器
 * 1、编写一个拦截器实现 HandlerInterceptor接口 (interceptor/LoginInterceptor)
 * 2、拦截器注册到容器中，实现 WebMvcConfigurer接口的 addInterceptors方法 (config/AdminWebConfig)
 * 3、指定拦截规则 (拦截所有时，静态资源也会被拦截)
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()) // 使用哪个拦截器
                .addPathPatterns("/**")             // 所有请求都被拦截，包括静态资源
                .excludePathPatterns("/","/login","/css/**","/js/**","/fonts/**","/images/**"); // 放行哪些请求
    }
}
