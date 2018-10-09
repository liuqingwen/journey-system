package com.journey.demo;

import com.journey.demo.data.config.DataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DataSourceConfig.class})
public class JourneySpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JourneySpringBootApplication.class, args);
	}
}
