package com.journey.demo;

import com.journey.demo.data.config.DataSourceConfig;
import com.journey.demo.data.config.DataSourceRoutingConfig;
import com.journey.demo.data.config.MapperScannerConfig;
import com.journey.demo.data.config.TransactionConfig;
import com.journey.demo.service.UserService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@EnableHystrix
@SpringBootApplication
@Import({DataSourceConfig.class, MapperScannerConfig.class, DataSourceRoutingConfig.class, TransactionConfig.class})
public class SpringBootDubboDemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootDubboDemoApplication.class, args);

        ConfigurableApplicationContext run = new SpringApplicationBuilder(SpringBootDubboDemoApplication.class).web(WebApplicationType.NONE).run(args);
//        new SpringApplicationBuilder().web(false).run(args);
        UserService userService = run.getBean("userService", UserService.class);
        System.out.println(userService.getUserName(""));


    }
}
