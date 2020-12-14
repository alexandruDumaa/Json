package com.cmc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.cmc.hibernate.controlador","com.cmc.hibernate.dao","com.cmc.hibernate.modelo","com.cmc.hibernate.persistencia","com.cmc.hibernate.repositorio"})
@ComponentScan(basePackages={"com.cmc.hibernate.controlador","com.cmc.hibernate.dao","com.cmc.hibernate.modelo","com.cmc.hibernate.persistencia","com.cmc.hibernate.repositorio"})
public class ServicioJsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioJsonApplication.class, args);
	}

}
