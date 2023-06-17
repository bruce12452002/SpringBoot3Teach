package home.bruce.SpringBoot3Teach.controller;

import home.bruce.SpringBoot3Teach.bean.WuKon;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Slf4j  // 使用了 lombok 後，可以用這個註解，然後自然有個 log 變數可用
@RestController
public class MyController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello")
    public String hello() {
//        logger.info("hello method");
        log.info("hello method");
        return "yeah";
    }

    /**
     * maven 需要加上 xml 的依賴
     * <p>
     * 使用 postman 測試，header 的 Accept，application/json 和 application/xml 可看出效果
     * <p>
     * format=xml 或 format=json 也可以，但預設是關閉的，要在 application.properties 打開
     * header 和 format 都使用，會以 format 為準
     */
    @GetMapping("/negotiation")
    public WuKon negotiation() {
        return new WuKon();
    }

    /**
     * No message found under code 'key' for locale 'zh_TW'
     * 一定要有不帶國碼的 xxx.properties
     */
    @GetMapping("/i18n")
    public void i18n(HttpServletRequest request) {
        Locale locale = request.getLocale();
        System.out.println(messageSource.getMessage("msg", new String[]{"龍", "測試"}, locale));

        String cn = messageSource.getMessage("msg", new String[]{"龙", "测试", "3"}, Locale.CHINA);
        String tw = messageSource.getMessage("msg", new String[]{"龍", "測試"}, Locale.TAIWAN);
        String us = messageSource.getMessage("msg", new String[]{"dragon"}, Locale.ENGLISH);

        System.out.println("cn=" + cn);
        System.out.println("tw=" + tw);
        System.out.println("us=" + us);
    }
}
