package com.jcoder.school;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.h2.server.web.WebServlet;

/*
To use h2 in console in browser
 */
@Configuration
public class WebConfiguration {

    @Bean
    ServletRegistrationBean h2ServletRegistration(){
        ServletRegistrationBean registrationBean =
                new ServletRegistrationBean(new WebServlet());

        registrationBean.addUrlMappings("/console/*");
        return registrationBean;
    }


}
