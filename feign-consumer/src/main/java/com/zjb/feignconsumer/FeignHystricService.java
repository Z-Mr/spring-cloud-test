package com.zjb.feignconsumer;

import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author jibin.zhang
 * @Date 2019/4/24 11:08
 **/
@Component
public class FeignHystricService implements FeignHiClient {

    @Override
    public String hi() {
        return "Feign system error";
    }
}
