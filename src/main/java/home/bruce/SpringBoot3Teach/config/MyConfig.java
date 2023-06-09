package home.bruce.SpringBoot3Teach.config;

import home.bruce.SpringBoot3Teach.bean.Dog;
import home.bruce.SpringBoot3Teach.bean.Monkey;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
@EnableConfigurationProperties(Dog.class) // 可用在第三方
public class MyConfig {
    @Bean
//    @ConfigurationProperties(prefix = "m")
    public Monkey getMonkey() {
        return new Monkey();
    }

    @Bean
    public Dog getDog() {
        return new Dog();
    }
}
