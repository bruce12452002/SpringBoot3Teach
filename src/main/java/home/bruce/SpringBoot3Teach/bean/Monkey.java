package home.bruce.SpringBoot3Teach.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
//@Component
@ConfigurationProperties(prefix = "m")
// 以下兩個屬性，如果不忽略，啟動時會報錯
// ignoreInvalidFields 預設 false，如果 properties 設定了無效的值，要不要忽略，如 int 的欄位給 String
// ignoreUnknownFields 預設 true，如果 properties 設定了沒有的欄位，要不要忽略，如沒有 wight 這個欄位
public class Monkey {
    private int id;
    private String name;
    private WuKon wk; // WuKon 不需要 @Component
}
