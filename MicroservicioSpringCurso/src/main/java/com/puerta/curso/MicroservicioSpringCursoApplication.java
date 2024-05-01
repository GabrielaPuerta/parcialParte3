package com.puerta.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"com.puerta.common.usuario.models.entity.*",
	"com.puerta.curso.models.entity.*" })
@EnableJpaRepositories({"com.puerta.common.usuario.models.entity.*", "com.puerta.curso.models.entity.*"})
@EntityScan({"com.puerta.common.usuario.models.entity.*", "com.puerta.curso.models.entity.*"})

public class MicroservicioSpringCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioSpringCursoApplication.class, args);
	}

}
