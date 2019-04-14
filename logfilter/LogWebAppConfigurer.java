package com.Estate.logfilter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Administrator on 2018/8/13.
 */
@Configuration
public class LogWebAppConfigurer extends WebMvcConfigurerAdapter {

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new RequestParamAndBodyInterceptor()).addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }
//    @Bean
//    public FilterRegistrationBean repeatedlyReadFilter() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        LogFilter logFilter = new LogFilter();
//        registration.setFilter(logFilter);
//        registration.addUrlPatterns("/*");
//        return registration;
//    }
}