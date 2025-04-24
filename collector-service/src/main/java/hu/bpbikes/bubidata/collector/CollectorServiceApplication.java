package hu.bpbikes.bubidata.collector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@ComponentScan("hu.bpbikes.bubidata.collector_service.bikeusage")
public class CollectorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollectorServiceApplication.class, args);
	}

}
