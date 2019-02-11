package cn.github.mrjerryli.nacos.server.controller;

/***************************
 * 公司：  魔拼网络科技
 * 时间： 2019-02-11 18:14
 * Created by IntelliJ IDEA.
 ***************************/

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 魔拼. 和有趣的人拼享生活。
 *
 * @author jerry.li
 * description:
 * path: springcloud-learningcase-cn.github.mrjerryli.nacos.server.controller-TestController
 * date: 2019-02-11 18:14
 * version: 2.0.1
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello(String name){

        log.info("name:{}",name);
        return  "hello" + name;
    }
}
