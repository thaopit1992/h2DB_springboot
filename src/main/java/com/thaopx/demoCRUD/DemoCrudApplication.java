package com.thaopx.demoCRUD;

import com.thaopx.demoCRUD.service.AppPropertiesTestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties // Cấu hình properties

public class DemoCrudApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(DemoCrudApplication.class, args);

		AppPropertiesTestService appPropertiesTestService = context.getBean(AppPropertiesTestService.class);
		appPropertiesTestService.getAppInfo();
	}

}
