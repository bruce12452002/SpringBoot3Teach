package home.bruce.SpringBoot3Teach.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "d")
public class Dog {
    private int id;
    private String name;
}
