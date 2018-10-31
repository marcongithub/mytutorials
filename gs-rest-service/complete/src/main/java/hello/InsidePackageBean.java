package hello;

import org.springframework.stereotype.Component;

@Component
public class InsidePackageBean {

    public void sayHello(){
        System.out.println("Hello from inside!");
    }
}
