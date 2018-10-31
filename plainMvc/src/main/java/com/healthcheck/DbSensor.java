package com.healthcheck;

import org.springframework.stereotype.Component;

@Component
public class DbSensor implements Sensor{
    @Override
    public String getName() {
        return "DbSensor";
    }

    @Override
    public boolean isHealthy() {
        return false;
    }
}
