package cn.github.mrjerryli.nacos.client.controller;

/***************************
 * 公司：  魔拼网络科技
 * 时间： 2019-02-11 18:38
 * Created by IntelliJ IDEA.
 ***************************/

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 魔拼. 和有趣的人拼享生活。
 *
 * @author jerry.li
 * description:
 * path: springcloud-learningcase-cn.github.mrjerryli.nacos.client.controller-TestController
 * date: 2019-02-11 18:38
 * version: 2.0.1
 * To change this template use File | Settings | File Templates.
 */

@Slf4j
@RestController
public class TestController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    /**
     * 方法名：
     * 功能：通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
     * 描述：
     * 创建人：typ
     * 创建时间：2019/1/21 10:54
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/test")
    public String test() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("alibaba-nacos-server");
        String url = serviceInstance.getUri() + "/hello?name=" + "zhangsan";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "Invoke : " + url + ", return : " + result;
    }

}
