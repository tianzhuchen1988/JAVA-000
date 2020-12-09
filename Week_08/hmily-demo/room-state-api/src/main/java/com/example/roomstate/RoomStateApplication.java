package com.example.roomstate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chentz
 * @version v1.0
 * @date 2020/12/9 20:55
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class RoomStateApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomStateApplication.class, args);
    }

}
