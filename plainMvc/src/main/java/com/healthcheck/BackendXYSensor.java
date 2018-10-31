package com.healthcheck;

import org.springframework.stereotype.Component;

@Component
public class BackendXYSensor implements Sensor{
    @Override
    public String getName() {
        return "BackendXYSensor";
    }

    @Override
    public boolean isHealthy() {
        return false;
    }
}
