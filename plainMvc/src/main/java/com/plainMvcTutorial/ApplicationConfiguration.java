package com.plainMvcTutorial;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.plainMvcTutorial", "com.healthcheck", "com.offer"})
public class ApplicationConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        // geht auch ohne
        // configurer.favorPathExtension(false).favorParameter(false).ignoreAcceptHeader(false).useJaf(false);
        super.configureContentNegotiation(configurer);
    }

}
