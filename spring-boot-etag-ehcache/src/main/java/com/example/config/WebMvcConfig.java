package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.cache.CacheInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer  {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CacheInterceptor())
        	    .addPathPatterns("/cache/*");
    }
}
