package hu.bpbikes.bubidata.collector.weather;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WeatherApiClient {

    @Bean
    @Qualifier("weatherApiWebClient")
    WebClient webClient(@Value("${weather.api.base.url}") String weatherApiBaseUrl) {
        return WebClient.builder()
                .baseUrl(weatherApiBaseUrl)
                .defaultHeader("Accept", "application/json")
                .build();
    }

}
