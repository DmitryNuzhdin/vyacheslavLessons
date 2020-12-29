package orm;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaContext;

@SpringBootApplication
public class OrmApp {
    private static final Logger log = LoggerFactory.getLogger(OrmApp.class);

    public static void main(String[] args) {
        SpringApplication.run(OrmApp.class);
    }

    @Bean
    public CommandLineRunner demo(ConsumerRepo consumerRepo, OrderRepo orderRepo) {
        return (args) -> {
            Consumer c1 = new Consumer("Dima");
            Order o1 = new Order(c1);



            log.info("----------------");
            //log.info(c1.toString());
            consumerRepo.save(c1);
            orderRepo.save(o1);
            //log.info(c1.toString());
            consumerRepo.findByName("Dima").forEach(c -> log.info(c.toString()));
            orderRepo.findAll().forEach(c -> log.info(c.toString()));
        };
    }
}
