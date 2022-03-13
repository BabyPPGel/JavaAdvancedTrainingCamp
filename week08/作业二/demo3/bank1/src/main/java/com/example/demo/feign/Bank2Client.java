package com.example.demo.feign;

import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="TCC-DEMO-BANK2",fallback=Bank2ClientFallback.class)
public interface Bank2Client {

    //远程调用用户B微服务
    @GetMapping("/bank2/transfer")
    @Hmily
    public  Boolean transfer(@RequestParam("amount") Double amount);
}

