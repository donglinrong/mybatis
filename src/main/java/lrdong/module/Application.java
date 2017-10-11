package lrdong.module;

import lrdong.module.dao.SysUserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(
        basePackages = {
                "lrdong.module.dao"
        }
)
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
