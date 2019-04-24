package com.zjb.feignconsumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Author jibin.zhang
 * @Date 2019/4/23 9:41
 **/
@FeignClient(value = "eureka-client",fallback = FeignHystricService.class)
public interface FeignHiClient {

    @RequestMapping("/hi")
    String hi();

}
