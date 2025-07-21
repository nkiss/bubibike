package hu.bpbikes.bubidata.persistence.data;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

import hu.bpbikes.bubidata.bikeusage.model.BikeUsage;
import hu.bpbikes.bubidata.weather.model.Weather;

@Service
public class DataServiceClient {
	
	private final WebClient webClient;
	
	public DataServiceClient(WebClient webClient) {
		this.webClient = webClient;
	}
	
	/*
	 * public void saveWeather(Weather weather) { this.webClient.post()
	 * .uri("/weather") .bodyValue(weather) .retrieve() .bodyToMono(Void.class)
	 * .subscribe(); }
	 * 
	 * public void saveUsage(BikeUsage bikeUsage) {
	 * bikeUsage.getNetwork().getStations().stream().
	 * 
	 * this.webClient.post() .uri("/usage") .body() }
	 */
	
}
