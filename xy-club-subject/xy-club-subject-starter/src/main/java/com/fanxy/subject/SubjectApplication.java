package com.fanxy.subject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: SubjectApplication
 * Package: com.fanxy.subject
 * Description:
 *
 *      刷题微服务启动类
 *
 * @Author FanXY
 * @Create 2024/3/12 17:53
 * @Version 1.0
 */
@SpringBootApplication
@ComponentScan("com.fanxy")
@MapperScan("com.fanxy.**.mapper")
public class SubjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class);
    }
}
