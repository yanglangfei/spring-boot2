package com.yanglf.mvc;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author yanglf
 * @sine 2019.02.01
 * @descriptipon
 * @see
 */
@SpringBootApplication
@ServletComponentScan(basePackages = {"com.yanglf.mvc.servlet","com.yanglf.mvc.filter"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
