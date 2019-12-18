package pub.imlichao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 包含了 @Configuration @EnableAutoConfiguration @ComponentScan 三个注解
public class App {
    public static void main(String[] args) {
        //运行spring boot web项目
        SpringApplication.run(App.class, args);
    }
}