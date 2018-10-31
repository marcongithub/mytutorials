package outside;


import org.springframework.stereotype.Component;

@Component
public class OutsidePackageBean {

    public void sayHello(){
        System.out.println("Hello from outside!");
    }
}
