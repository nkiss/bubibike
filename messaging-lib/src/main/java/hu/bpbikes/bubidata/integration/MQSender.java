package hu.bpbikes.bubidata.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import hu.bpbikes.bubidata.bikeusage.model.BikeUsage;
import hu.bpbikes.bubidata.weather.model.Weather;

@Service
public class MQSender {
	
	private static final Logger log = LoggerFactory.getLogger(MQSender.class);
	
	private final RabbitTemplate rabbitTemplate;
	
	public MQSender(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendWeatherData(Weather weatherDto) {
        rabbitTemplate.convertAndSend(IntegrationConfig.WEATHER_QUEUE, weatherDto);
    }

    public void sendBikeUsageData(BikeUsage bikeUsageDto) {
        rabbitTemplate.convertAndSend(IntegrationConfig.BIKE_USAGE_QUEUE, bikeUsageDto);
    }
	
}
