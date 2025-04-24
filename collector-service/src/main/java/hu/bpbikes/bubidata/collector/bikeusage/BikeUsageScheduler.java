package hu.bpbikes.bubidata.collector.bikeusage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BikeUsageScheduler {
    private static final Logger logger = LoggerFactory.getLogger(BikeUsageScheduler.class);

    private static final int FREQUENCY_IN_MILLISECONDS = 10000;

    private final BikeUsageService bikeUsageService;

    public BikeUsageScheduler(final BikeUsageService bikeUsageService) {
        this.bikeUsageService = bikeUsageService;
    }

    @Scheduled(fixedRate = FREQUENCY_IN_MILLISECONDS)
    public void schedule() {
        logger.info("BikeUsage scheduler starts");
        try {
            this.bikeUsageService.fetchData().subscribe(
                response ->
                        logger.info("Stations count: " +
                                String.valueOf(response.getNetwork().getStations().size()))
            );
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
