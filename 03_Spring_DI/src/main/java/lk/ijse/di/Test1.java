package lk.ijse.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test1 implements Di{
    public Test1() {
        System.out.println("Test1 constructor");
    }

    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }
}
