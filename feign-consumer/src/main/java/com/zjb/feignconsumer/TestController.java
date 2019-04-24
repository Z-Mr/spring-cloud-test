package com.zjb.feignconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author jibin.zhang
 * @Date 2019/4/23 9:43
 **/
@RestController
public class TestController {

    @Autowired
    private FeignHiClient feignHiClient;


    @RequestMapping("/consumer")
    public String consumer(){
        return feignHiClient.hi();
    }

}
