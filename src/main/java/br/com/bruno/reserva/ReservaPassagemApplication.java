package br.com.bruno.reserva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "br.com.bruno.reserva.repository")
public class ReservaPassagemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservaPassagemApplication.class, args);
	}

}
