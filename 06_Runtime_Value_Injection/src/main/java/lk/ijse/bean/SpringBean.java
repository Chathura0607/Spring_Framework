package lk.ijse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//import org.springframework.stereotype.Component;
@Component
public class SpringBean implements InitializingBean {
    @Value("Achini")
    private String name;

    public SpringBean() {
        System.out.println(name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name);
    }
}

//@Component
//public class SpringBean {
//    public SpringBean() {}
//@Autowired(required = false)
//public SpringBean(@Value("Achini")String name,@Value("1") int id, @Value("true") boolean b) {
//        System.out.println("SpringBean Object Created");
//        System.out.println(name);
//        System.out.println(id);
//        System.out.println(b);
//    }
//
//    @Autowired(required = false)
//    public SpringBean(@Value("Achini")String name,@Value("1") int id) {
//        System.out.println("SpringBean Object Created");
//        System.out.println(name);
//        System.out.println(id);
//    }
//}
