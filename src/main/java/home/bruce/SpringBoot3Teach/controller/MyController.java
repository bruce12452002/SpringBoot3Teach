package home.bruce.SpringBoot3Teach.controller;

import home.bruce.SpringBoot3Teach.bean.WuKon;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j  // 使用了 lombok 後，可以用這個註解，然後自然有個 log 變數可用
@RestController
public class MyController {
    Logger logger = LoggerFactory.getLogger(getClass());

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
}
