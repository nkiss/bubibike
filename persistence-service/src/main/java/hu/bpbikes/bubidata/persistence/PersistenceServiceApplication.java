package hu.bpbikes.bubidata.persistence;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class PersistenceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersistenceServiceApplication.class, args);
	}

}
