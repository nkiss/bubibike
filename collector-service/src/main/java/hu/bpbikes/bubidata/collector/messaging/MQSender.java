package hu.bpbikes.bubidata.collector.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
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
		try {
			rabbitTemplate.convertAndSend(
					IntegrationConfig.WEATHER_EXCHANGE, 
					IntegrationConfig.WEATHER_ROUTING_KEY,
					weatherDto);
		} catch (AmqpException e) {
			log.error("Weather data message sending failed.", e);
		}
	}

	public void sendBikeUsageData(BikeUsage bikeUsageDto) {
		try {
			rabbitTemplate.convertAndSend(
					IntegrationConfig.BIKE_USAGE_EXCHANGE,
					IntegrationConfig.BIKE_USAGE_ROUTING_KEY, 
					bikeUsageDto);
		} catch (AmqpException e) {
			log.error("Bike usage data message sending failed.", e);
		}
	}

}
