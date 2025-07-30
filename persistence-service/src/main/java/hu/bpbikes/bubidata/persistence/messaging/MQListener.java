package hu.bpbikes.bubidata.persistence.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import hu.bpbikes.bubidata.bikeusage.model.BikeUsage;
import hu.bpbikes.bubidata.persistence.data.StationDataService;
import hu.bpbikes.bubidata.persistence.data.WeatherDataService;
import hu.bpbikes.bubidata.weather.model.Weather;

@Component
@Profile({"dev", "prod"})
public class MQListener {
	
	private static final Logger log = LoggerFactory.getLogger(MQListener.class);
	
	private final StationDataService stationDataService;
	
	private final WeatherDataService weatherService;
	
	public MQListener(final StationDataService stationDataService, WeatherDataService weatherService) {
		super();
		log.info("MQListener is starting up...");
		this.stationDataService = stationDataService;
		this.weatherService = weatherService;
	}

	@RabbitListener(queues = IntegrationConfig.WEATHER_QUEUE)
    public void receiveWeatherData(Weather weatherDto) {
		try {
			log.debug("Received weather data: {}", weatherDto);
			weatherService.saveWeatherData(weatherDto);
			stationDataService.updateSnapshots();
		} catch (Exception e) {
			log.error("Weather listener failed.", e);
		}
    }

    @RabbitListener(queues = IntegrationConfig.BIKE_USAGE_QUEUE)
    public void receiveBikeUsageData(BikeUsage bikeUsageDto) {
        try {
        	log.debug("Received bike usage data: {}", bikeUsageDto);
        	stationDataService.saveSnapshot(bikeUsageDto);
        } catch (Exception e) {
			log.error("Bike usage listener error", e);
		}
    }

}
