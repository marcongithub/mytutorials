package com.anypackage;


import com.healthcheck.Sensor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnyConfig {

    @Bean
    public Sensor getAnySensor(){
        return new Sensor() {
            @Override
            public String getName() {
                return "AnySensor";
            }

            @Override
            public boolean isHealthy() {
                return false;
            }
        };
    }
}
