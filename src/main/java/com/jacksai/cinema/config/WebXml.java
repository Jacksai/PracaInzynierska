package com.jacksai.cinema.config;

import com.jacksai.cinema.Application;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebXml extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(Application.class);
    }

}
