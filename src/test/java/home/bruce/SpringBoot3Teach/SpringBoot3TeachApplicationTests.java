package home.bruce.SpringBoot3Teach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringBoot3TeachApplication.class)
class SpringBoot3TeachApplicationTests {
    @Autowired
    private BeanFactory beanFactory;

    @Test
    void testAutoConfigurationPackage() {
        AutoConfigurationPackages.get(beanFactory).forEach(System.out::println);
    }

}
