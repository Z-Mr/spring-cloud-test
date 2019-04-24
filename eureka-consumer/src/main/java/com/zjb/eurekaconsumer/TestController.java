package com.zjb.eurekaconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description TODO
 * @Author jibin.zhang
 * @Date 2019/4/22 17:27
 **/
@RestController
public class TestController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/consumer")
    public String hi(){
        ServiceInstance instance = loadBalancerClient.choose("eureka-client");
        String url = "http://"+ instance.getHost() + ":" + instance.getPort() + "/hi";
        log.info("url:{}",url);
        return restTemplate.getForObject(url,String.class);
    }
}
