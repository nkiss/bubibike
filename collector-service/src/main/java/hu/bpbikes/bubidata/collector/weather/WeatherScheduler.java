package hu.bpbikes.bubidata.collector.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import hu.bpbikes.bubidata.collector.messaging.MQSender;

@Component
@ConfigurationProperties(prefix = "scheduler.weather")
public class WeatherScheduler {
	
	private static final Logger logger = LoggerFactory.getLogger(WeatherScheduler.class);
	
	private final WeatherService weatherService;
	private final MQSender mqSender;
	
	public WeatherScheduler(final WeatherService weatherService, final MQSender mqSender) {
		this.weatherService = weatherService;
		this.mqSender = mqSender;
	}
	
	@Scheduled(fixedRateString = "${remote.api.call.schedule.fixedrate}")
	public void schedule() {
		logger.debug("WeatherScheduler starts");
		try {	
			weatherService.fetchData().subscribe(
					response -> {
						logger.info("Weather fetch date: {}", String.valueOf(response.getWeatherData().getTime()));
						mqSender.sendWeatherData(response);
					});
						
		} catch (Exception e) {
			logger.error("Error occured while running scheduled weather data fetch", e);
		}
	}
	
}
