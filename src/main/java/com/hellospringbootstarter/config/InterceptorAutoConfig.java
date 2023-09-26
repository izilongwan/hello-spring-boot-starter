package com.hellospringbootstarter.config;

import javax.annotation.Resource;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hellospringbootstarter.entity.Hello;
import com.hellospringbootstarter.interceptor.LogInterceptor;

@Configuration
@EnableConfigurationProperties(Hello.class)
public class InterceptorAutoConfig implements WebMvcConfigurer {
    @Resource
    LogInterceptor logInterceptor;

    @Resource
    Hello hello;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logInterceptor);
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
