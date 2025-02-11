package lk.ijse.bean;

import org.springframework.stereotype.Component;

//@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SpringBean {
    public SpringBean() {
        System.out.println("SpringBean Object Created");
    }
}
