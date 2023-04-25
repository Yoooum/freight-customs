package com.prprv.customs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class FreightCustomsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreightCustomsApplication.class, args);
        log.info("启动成功：修改演示");
    }

}
