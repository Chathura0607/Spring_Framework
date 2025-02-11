package lk.ijse.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SpringBean {
    public SpringBean() {
        System.out.println("SpringBean Object Created");
    }

    public void testBean() {
        System.out.println("SpringBean Object Tested");
    }
}
