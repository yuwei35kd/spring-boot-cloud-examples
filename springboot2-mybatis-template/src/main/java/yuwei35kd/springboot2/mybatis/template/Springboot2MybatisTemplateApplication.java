package yuwei35kd.springboot2.mybatis.template;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("yuwei35kd.springboot2.mybatis.template.dao")
public class Springboot2MybatisTemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot2MybatisTemplateApplication.class, args);
    }

}
