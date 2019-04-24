package com.zjb.ribbonconsumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("/consumer")
    @HystrixCommand(fallbackMethod = "systemError")
    public String hi(){
        return restTemplate.getForObject("http://eureka-client/hi",String.class);
    }

    public String systemError(){
        return "eureka-client can system error, please try again later!";
    }

}
