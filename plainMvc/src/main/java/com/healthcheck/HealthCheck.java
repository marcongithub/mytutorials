package com.healthcheck;


import com.plainMvcTutorial.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthchecker")
public class HealthCheck {

    @Autowired
    private Sensor[] sensors;

    @RequestMapping(value = "/check", method = RequestMethod.GET, produces = { "application/xml" })
    public BaseResponse healthCheck() {

        for(Sensor sensor : sensors){
            System.out.println(sensor.getName());
        }

        return new BaseResponse("100", 1);
    }

}
