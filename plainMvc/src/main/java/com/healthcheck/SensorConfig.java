package com.healthcheck;


import com.anypackage.AnyConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AnyConfig.class)
public class SensorConfig {

    @Bean
    public Sensor getMongoDbSensor(){
        return new Sensor() {
            @Override
            public String getName() {
                return "MongoDBSensor";
            }

            @Override
            public boolean isHealthy() {
                return false;
            }
        };
    }
}
