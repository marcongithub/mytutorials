package hello;

import hello.model.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import outside.OutsidePackageBean;

@SpringBootApplication
@ComponentScan(basePackages = {"hello", "outside"})
public class Application implements CommandLineRunner {

    @Autowired
    OutsidePackageBean outside;

    @Autowired
    InsidePackageBean inside;

    @Autowired
    OfferRepository offerRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        System.out.println("####### user dir: "+System.getProperty("user.dir"));
//        Offer newOffer = new Offer();
//        newOffer.setDescription("myfirstoffer");
//        offerRepository.save(newOffer);
//
//        Optional<Offer> offer = offerRepository.findById(newOffer.getId());
//        System.out.println("######## offer description: "+offer.get().getDescription());
//
//        outside.sayHello();
//        inside.sayHello();
    }
}
