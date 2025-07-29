package hu.bpbikes.bubidata.collector.bikeusage;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BikeUsageClient {
	
	@Bean
	@Qualifier("bikeUsageWebClient")
	public WebClient webClient(@Value("${citybik.api.base}") String cityBikBaseUrl) {
		return WebClient.builder().baseUrl(cityBikBaseUrl).build();
	}
	
}
