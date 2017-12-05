package io.nagarro.exit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class CasinoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasinoApiApplication.class, args);
	}
}
