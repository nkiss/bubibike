package hu.bpbikes.bubidata.collector.bikeusage;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import hu.bpbikes.bubidata.bikeusage.model.BikeUsage;
import reactor.core.publisher.Mono;

@Service
public class BikeUsageService {

    private static final Logger logger = LoggerFactory.getLogger(BikeUsageService.class);

    private final WebClient bikeUsageWebClient;
    
    private final BikeUsageProps bikeUsageProps;

    public BikeUsageService(
    		BikeUsageProps bikeUsageProps, 
    		@Qualifier("bikeUsageWebClient") WebClient bikeUsageWebClient) {
    	this.bikeUsageProps = bikeUsageProps;
        this.bikeUsageWebClient = bikeUsageWebClient;
    }

    public Mono<BikeUsage> fetchData() {
        logger.info("Fetching bike usage data from Nextbike GmbH API...");

        return bikeUsageWebClient.get()
            .uri(bikeUsageProps.getEndpoint())
            .retrieve()
            .bodyToMono(BikeUsage.class)
            .timeout(Duration.ofSeconds(bikeUsageProps.getTimeout()))
            .doOnSuccess(
                    response -> {
                        logger.debug("Successfully fetched bike usage from {}", response.getNetwork());
                    }
            )
            .doOnError(throwable ->
                    logger.error("Failed to fetch Nextbike GmbH public bike usage API",
                    throwable)
            ).log();
    }

}