package home.bruce.SpringBoot3Teach;

import home.bruce.SpringBoot3Teach.bean.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * @SpringBootApplication 裡的註解
 * --@SpringBootConfiguration 可當 @Configuration
 * --@ComponentScan 只會掃此包和此包下的子包，如果想加載其他非子包，可再用 @ComponentScan 或 scanBasePackages 屬性
 * --@EnableAutoConfiguration 使用 @Import 加載 AutoConfigurationImportSelector，覆寫 ImportSelector 的 selectImports 方法
 * 會加載 META-INF/spring/%s.imports 檔案的類別
 * maven 的 spring-boot-starter 底層是 spring-boot-autoconfigure，這一包的 META-INF/spring/%s.imports，假設要看 tomcat，
 * EmbeddedWebServerFactoryCustomizerAutoConfiguration 裡就有相關的設定
 * 假設在 maven 加了spring 的 redis 後，也會有 RedisAutoConfiguration，只要 spring 有的，就找 xxxAutoConfiguration
 * ----@AutoConfigurationPackage SpringBoot 啟動時會將啟動類別所在的包當作自動設定的包
 * <p>
 * @ConditionaOnXxx @ConditionalOnMissingXxx 如果[有|沒有]什麼才加載到 spring 容器
 */
@SpringBootApplication
public class SpringBoot3TeachApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(SpringBoot3TeachApplication.class, args);
//        Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);

//        testConditionOnXxx(context);
        testDefaultValueWithConfigurationProperties(context);
//        testDefaultValueWithEnableConfigurationProperties(context);

    }

    private static void testConditionOnXxx(ConfigurableApplicationContext context) {
        System.out.println("tiger=" + Arrays.toString(context.getBeanNamesForType(Tiger.class)));
        System.out.println("cat=" + Arrays.toString(context.getBeanNamesForType(Cat.class)));
        System.out.println("man=" + Arrays.toString(context.getBeanNamesForType(Man.class)));
        System.out.println("woman=" + Arrays.toString(context.getBeanNamesForType(Woman.class)));
    }

    private static void testDefaultValueWithConfigurationProperties(ConfigurableApplicationContext context) {
        Monkey m = context.getBean(Monkey.class);
//        Monkey m = context.getBean("getMonkey", Monkey.class);

        System.out.println(m.getId() + "=" + m.getName());
        WuKon wk = m.getWk();
        System.out.println(wk.getId() + "=" + wk.getName());

//        wk.getDogMap().forEach((k, v) -> System.out.println(k + "=" + v.getName()));
//        System.out.println(wk.getLs().get(2));
//        System.out.println(wk.getLs().get(3));
    }

    private static void testDefaultValueWithEnableConfigurationProperties(ConfigurableApplicationContext context) {
        Dog d = context.getBean("getDog", Dog.class);
        System.out.println(d.getId() + "=" + d.getName());
    }

}
