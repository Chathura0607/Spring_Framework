package lk.ijse.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test2 implements DIInjection{
    @Autowired
    Di test1;

//    public Test2(Di test1) {
//        this.test1 = test1;
//    }
//
//    public void display() {
//        test1.sayHello();
//    }

//    public void setter(Di test1) {
//        this.test1 = test1;
//    }
//
//    public void display() {
//        test1.sayHello();
//   }

    @Override
    public void inject() {
        this.test1.sayHello();
    }
}
