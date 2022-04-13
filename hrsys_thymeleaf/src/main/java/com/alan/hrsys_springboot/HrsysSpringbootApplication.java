package com.alan.hrsys_springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.alan.hrsys_springboot.dao")
public class HrsysSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrsysSpringbootApplication.class, args);
    }

}
