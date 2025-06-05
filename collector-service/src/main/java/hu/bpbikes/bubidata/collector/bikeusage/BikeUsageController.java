package hu.bpbikes.bubidata.collector.bikeusage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.bpbikes.bubidata.bikeusage.model.BikeUsage;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/api")
public class BikeUsageController {
    private static final Logger logger = LoggerFactory.getLogger(BikeUsageController.class);

    private final BikeUsageService bikeUsageService;

    public BikeUsageController(BikeUsageService bikeUsageService) {
        this.bikeUsageService = bikeUsageService;
    }

    @GetMapping("/bike-usage")
    public void getBikeUsage() {
        Mono<BikeUsage> bikeUsagePublisher = bikeUsageService.fetchData();
        bikeUsagePublisher.subscribe(
                response -> {
                    this.bikeUsageService.doSomething(response.getNetwork().getStations().size());
                }
        );
    }

}
