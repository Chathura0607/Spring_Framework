package lk.ijse.config;

import lk.ijse.bean.SpringBeanOne;
import lk.ijse.bean.SpringBeanThree;
import lk.ijse.bean.SpringBeanTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "lk.ijse.bean")
public class AppConfig {
//    @Bean
//    public SpringBeanOne springBeanOne() {
//        return new SpringBeanOne();
//    }
//
//    @Bean
//    public SpringBeanTwo springBeanTwo() {
//        return new SpringBeanTwo();
//    }

    //Inter Bean dependency
//    @Bean
//    public SpringBeanOne getSpringBeanOne() {
//        SpringBeanTwo springBeanTwo1 = getSpringBeanTwo();
//        SpringBeanTwo springBeanTwo2 = getSpringBeanTwo();
//        return new SpringBeanOne();
//    }
//
//    @Bean
//    public SpringBeanTwo getSpringBeanTwo() {
//        return new SpringBeanTwo();
//    }

//    @Bean
//    public SpringBeanTwo springBeanTwo() {
//        SpringBeanThree springBeanThree1 = springBeanThree();
//        SpringBeanThree springBeanThree2 = springBeanThree();
//        return new SpringBeanTwo();
//    }
//
//    @Bean
//    public SpringBeanThree springBeanThree() {
//        return new SpringBeanThree();
//    }
}

