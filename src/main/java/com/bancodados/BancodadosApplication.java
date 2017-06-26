package com.bancodados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.bancodados.controller.AlunoController;
import com.bancodados.controller.IndexController;
import com.bancodados.controller.ProfessorController;


@SpringBootApplication
@ComponentScan(basePackageClasses={IndexController.class, AlunoController.class, ProfessorController.class})
public class BancodadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancodadosApplication.class, args);
	}
}
