package com.hjzgg.test.thirdjar.config;

import com.hjzgg.test.thirdjar.web.interceptor.RequestLogInterceptorHandler;
import com.hjzgg.test.thirdjar.web.interceptor.ResubmitInterceptorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
//@Import(RedisUtils.class)
public class InterceptorConfig extends WebMvcConfigurerAdapter {

//    @Autowired
//    private RedisUtils redisUtils;

    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new ResubmitInterceptorHandler(redisUtils)).addPathPatterns("/**");
        registry.addInterceptor(new RequestLogInterceptorHandler());
    }
}
