package com.zjb.feignfileconsumer;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description TODO
 * @Author jibin.zhang
 * @Date 2019/4/23 10:41
 **/
@FeignClient(value = "feign-file-server",configuration = UploadFileService.MultipartSupportConfig.class)
public interface UploadFileService {

    @PostMapping(value = "/uploadFile",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String handleFileUpload(@RequestParam(value = "file") MultipartFile file);


    @Configuration
    class MultipartSupportConfig{
        @Bean
        public Encoder feignFormEncoder(){
            return new SpringFormEncoder();
        }
    }
}
