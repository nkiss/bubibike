package hu.bpbikes.bubidata.collector.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeatherScheduler {
	
	private static final int FREQUENCY_IN_MILLISECONDS = 10000;
	
	private static final Logger logger = LoggerFactory.getLogger(WeatherScheduler.class);
	
	private final WeatherService weatherService;
	
	public WeatherScheduler(final WeatherService weatherService) {
		this.weatherService = weatherService;
	}
	
	@Scheduled(fixedRate = FREQUENCY_IN_MILLISECONDS)
	public void schedule() {
		logger.debug("WeatherScheduler starts");
		try {
			//WeatherModel weatherModel = weatherService.fetchData();
			//logger.info("LATTI: " + String.valueOf(weatherModel.getWeather().getLatitude()));
			
			weatherService.fetchData().subscribe(
					response -> 
					logger.info("Weather date: " + String.valueOf(response.getWeatherData().getTime()))
					);
		} catch (Exception e) {
			logger.error("Error occured while running scheduled weather data fetch", e);
		}
	}
	
}
