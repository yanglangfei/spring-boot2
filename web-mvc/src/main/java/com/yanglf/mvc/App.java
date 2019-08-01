package com.yanglf.mvc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

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
