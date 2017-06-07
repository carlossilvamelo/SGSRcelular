package com.SGSRcelular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.SGSRcelular.controller.HomeController;


@SpringBootApplication
@ComponentScan(basePackageClasses={HomeController.class}, basePackages="com.SGSRcelular.*")
public class SgsRcelularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgsRcelularApplication.class, args);
	}	
}
