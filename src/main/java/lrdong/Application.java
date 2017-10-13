package lrdong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan(
        basePackages = {
                "lrdong.module.dao"
        }
)
public class Application {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder().build();
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
