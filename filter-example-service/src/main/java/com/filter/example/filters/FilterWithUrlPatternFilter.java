package com.filter.example.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FilterWithUrlPatternFilter {

    @Bean
    public FilterRegistrationBean<RequestResponseLoggingFilter>  loggingFilter(){
        FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new RequestResponseLoggingFilter());
        registrationBean.addUrlPatterns("/api/user/*");
        registrationBean.setOrder(2);
        return registrationBean;
    }

}
