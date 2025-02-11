package lk.ijse.config;

import lk.ijse.bean.SpringBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import({AppConfig1.class,AppConfig2.class})
//@ImportResource("classpath:hibernate.xml") - root path
@ImportResource("file:absolute-path-of-hibernate.xml") //if not
public class AppConfig {
    @Bean
    public SpringBean springBean() {
        return new SpringBean();
    }

}

