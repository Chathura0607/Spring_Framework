package lk.ijse.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Boy {
    @Qualifier
    @Autowired
    Agreement girl;

    public Boy() {
        System.out.println("Boy constructor");
    }

    public void chatWithGirl() {
        girl.chat();
    }
}
