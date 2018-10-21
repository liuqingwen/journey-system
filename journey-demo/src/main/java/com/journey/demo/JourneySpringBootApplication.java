package com.journey.demo;

import com.journey.demo.data.config.DataSourceConfig;
import com.journey.demo.data.config.MapperScannerConfig;
import com.journey.demo.web.config.WebXmlConfig;
import com.journey.demo.web.config.servlet.ServletConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@ServletComponentScan
@Import({DataSourceConfig.class, MapperScannerConfig.class, WebXmlConfig.class, ServletConfig.class})
public class JourneySpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JourneySpringBootApplication.class, args);
	}
}
