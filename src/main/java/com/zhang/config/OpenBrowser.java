package com.zhang.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
//自动打开浏览器的配置类
public class OpenBrowser implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        try {
            Runtime.getRuntime().exec("cmd   /c   start   http://localhost:8080");//可以指定自己的路径
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
