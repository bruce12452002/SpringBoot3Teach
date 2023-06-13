package home.bruce.SpringBoot3Teach.controller;

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
    public String hello(){
//        logger.info("hello method");
        log.info("hello method");
        return "yeah";
    }
}
