package lk.ijse.config;

import lk.ijse.bean.MyConnection;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

@ComponentScan(basePackages = "lk.ijse.bean")
public class AppConfig {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    MyConnection getMyConnection() {
        return new MyConnection();
    }
}
