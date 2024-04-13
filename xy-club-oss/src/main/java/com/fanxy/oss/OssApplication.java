package com.fanxy.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Description:
 *
 * @Author FanXY
 * @Create 2024/4/13 19:37
 * @Version 1.0
 */
@SpringBootApplication
@ComponentScan("com.fanxy")
public class OssApplication {
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class);
    }
}
