package com.jtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author JT.L
 * @date 2020/2/22 17:34:05
 * @description
 */
@SpringBootApplication
@MapperScan("com.jtl.user.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
}
