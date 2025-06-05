package hu.bpbikes.bubidata.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import hu.bpbikes.bubidata.bikeusage.model.BikeUsage;
import hu.bpbikes.bubidata.weather.model.Weather;

@Service
public class MQListener {
	
	private static final Logger log = LoggerFactory.getLogger(MQListener.class);
	
	@RabbitListener(queues = IntegrationConfig.WEATHER_QUEUE)
    public Weather receiveWeatherData(Weather weatherDto) {
        log.debug("Received weather data: {}", weatherDto);
        return weatherDto;
    }

    @RabbitListener(queues = IntegrationConfig.BIKE_USAGE_QUEUE)
    public BikeUsage receiveBikeUsageData(BikeUsage bikeUsageDto) {
        log.debug("Received bike usage data: {}", bikeUsageDto);
        return bikeUsageDto;
    }

}
