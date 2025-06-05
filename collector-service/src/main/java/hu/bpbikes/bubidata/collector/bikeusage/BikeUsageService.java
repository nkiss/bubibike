package hu.bpbikes.bubidata.collector.bikeusage;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

import hu.bpbikes.bubidata.bikeusage.model.BikeUsage;
import reactor.core.publisher.Mono;

@Service
public class BikeUsageService {

    private static final String CITIBIK_BUBI_URL = "http://api.citybik.es/v2";
    private static final String CITIBIK_BUBI_ENDPOINT = "/networks/bubi";

    private static final Logger logger = LoggerFactory.getLogger(BikeUsageService.class);

    private final WebClient webClient;

    public BikeUsageService(RestClient.Builder restClientBuilder, WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(CITIBIK_BUBI_URL).build();
    }

    public Mono<BikeUsage> fetchData() {
        logger.info("Fetching bike usage data from Nextbike GmbH API...");

        return webClient.get()
            .uri(CITIBIK_BUBI_ENDPOINT)
            .retrieve()
            .bodyToMono(BikeUsage.class)
            .timeout(Duration.ofSeconds(5))
            .doOnSuccess(
                    response -> {
                        logger.debug("Successfully fetched bike usage from Nextbike GmbH");
                    }
            )
            .doOnError(throwable ->
                    logger.error("Failed to fetch Nextbike GmbH public bike usage API",
                    throwable)
            ).log();
    }

    public void doSomething(int count) {
        logger.info("Count: " + String.valueOf(count));
    }

}