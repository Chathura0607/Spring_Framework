package lk.ijse.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanOne implements BeanNameAware {
    @Bean
    public  SpringBeanTwo springBeanTwo() {
        SpringBeanThree springBeanThree1 = springBeanThree();
        SpringBeanThree springBeanThree2 = springBeanThree();

        System.out.println(springBeanThree1);
        System.out.println(springBeanThree2);
        return new SpringBeanTwo();
        }

    @Bean
public SpringBeanThree springBeanThree() {
        return new SpringBeanThree();
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(name);
    }
}
