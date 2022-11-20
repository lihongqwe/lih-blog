package com.lih.blogweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.lih")
@MapperScan("com.lih.**.dao")
@SpringBootApplication
public class BlogWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogWebApplication.class, args);
        System.out.println("~~~~lihBlog启动成功~~~");
    }
}
