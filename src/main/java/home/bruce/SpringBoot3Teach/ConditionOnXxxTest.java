package home.bruce.SpringBoot3Teach;

import home.bruce.SpringBoot3Teach.bean.Cat;
import home.bruce.SpringBoot3Teach.bean.Man;
import home.bruce.SpringBoot3Teach.bean.Tiger;
import home.bruce.SpringBoot3Teach.bean.Woman;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class ConditionOnXxxTest { // ConditionOnXxx 可放在 TYPE
    // @ConditionalOnClass(Tiger.class) // 有 Tiger 就會加載，並不是要在 spring 容器有才加載
    @ConditionalOnClass(name = "lombok.Getter")
    @Bean
    public Tiger getTiger() {
        return new Tiger();
    }

    @ConditionalOnMissingClass("lombok.Getter")
    @Bean
    public Cat getCat() {
        return new Cat();
    }

    @ConditionalOnBean(Tiger.class)
    @Bean
    public Man getMan() {
        return new Man();
    }

    @ConditionalOnMissingBean(Tiger.class)
    @Bean
    public Woman getWoman() {
        return new Woman();
    }
}
