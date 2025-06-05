package hu.bpbikes.bubidata.collector.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import hu.bpbikes.bubidata.collector.messaging.MQSender;
import hu.bpbikes.bubidata.weather.model.Weather;

@Component
public class WeatherScheduler {
	
	private static final int FREQUENCY_IN_MILLISECONDS = 10000;
	
	private static final Logger logger = LoggerFactory.getLogger(WeatherScheduler.class);
	
	private WeatherService weatherService;
	private MQSender mqSender;
	
	public WeatherScheduler(final WeatherService weatherService, final MQSender mqSender) {
		this.weatherService = weatherService;
		this.mqSender = mqSender;
	}
	
	@Scheduled(fixedRate = FREQUENCY_IN_MILLISECONDS)
	public void schedule() {
		logger.debug("WeatherScheduler starts");
		try {	
			weatherService.fetchData().subscribe(
					response -> {
						logger.info("Weather date: " + String.valueOf(response.getWeatherData().getTime()));
						mqSender.sendWeatherData(response);
					});
						
		} catch (Exception e) {
			logger.error("Error occured while running scheduled weather data fetch", e);
		}
	}
	
}
