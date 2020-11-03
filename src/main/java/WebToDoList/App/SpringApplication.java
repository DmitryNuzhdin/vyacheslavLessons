package WebToDoList.App;

import WebToDoList.DataBase.Db;
import WebToDoList.DataBase.Dispetcher;
import WebToDoList.DataBase.IDispetcher;
import WebToDoList.Interfaces.IMyInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = "WebToDoList")
public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringApplication.class);

//        context.registerBean(Db.class);
//        context.registerBean(Dispetcher.class);
//        context.refresh();
        //IDispetcher dispetcher = context.getBean(IDispetcher.class);
        Db db = context.getBean(Db.class);
        Map<String, Object> objects = context.getBeansOfType(Object.class);

        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }

        System.out.println("");

    }

//    @Bean
//    Db getDb(){
//        return new Db();
//    }
}
