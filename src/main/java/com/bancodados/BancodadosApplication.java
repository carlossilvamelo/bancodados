package com.bancodados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.bancodados.controller.IndexController;


@SpringBootApplication
@ComponentScan(basePackageClasses={IndexController.class,})
public class BancodadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancodadosApplication.class, args);
	}
}
