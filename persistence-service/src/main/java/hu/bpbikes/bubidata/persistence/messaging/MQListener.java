package hu.bpbikes.bubidata.persistence.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import hu.bpbikes.bubidata.bikeusage.model.BikeUsage;
import hu.bpbikes.bubidata.persistence.data.StationDataService;
import hu.bpbikes.bubidata.weather.model.Weather;

@Component
public class MQListener {
	
	private static final Logger log = LoggerFactory.getLogger(MQListener.class);
	
	private final StationDataService stationDataService;
	
	public MQListener(final StationDataService stationDataService) {
		super();
		System.out.println("MQ Listener started");
		log.info("MQListener is starting up...");
		this.stationDataService = stationDataService;
	}
	
	@RabbitListener(queues = IntegrationConfig.BIKE_USAGE_QUEUE)
	public void receiveRawMessage(String message) {
	    log.info("Raw message: {}", message);
	    try {
	        log.info("Received: {}", message);
	    } catch (Exception e) {
	        log.error("Error processing message", e);
	    }
	}

	/**@RabbitListener(queues = IntegrationConfig.WEATHER_QUEUE)
    public void receiveWeatherData(Weather weatherDto) {
        log.info("Received weather data: {}", weatherDto);
    }

    @RabbitListener(queues = IntegrationConfig.BIKE_USAGE_QUEUE)
    public void receiveBikeUsageData(BikeUsage bikeUsageDto) {
        try {
        	log.info("Received bike usage data: {}", bikeUsageDto);
        	this.stationDataService.saveSnapshot(bikeUsageDto);
        } catch (Exception e) {
			log.error("MQ listener error");
		}
    }**/

}
