package hu.bpbikes.bubidata.collector.bikeusage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import hu.bpbikes.bubidata.collector.messaging.MQSender;

@Component
public class BikeUsageScheduler {
    private static final Logger logger = LoggerFactory.getLogger(BikeUsageScheduler.class);

    private static final int FREQUENCY_IN_MILLISECONDS = 60000;

    private final BikeUsageService bikeUsageService;
    private final MQSender mqSender;

    public BikeUsageScheduler(final BikeUsageService bikeUsageService, final MQSender mqSender) {
        this.bikeUsageService = bikeUsageService;
        this.mqSender = mqSender;
    }

    @Scheduled(fixedRate = FREQUENCY_IN_MILLISECONDS)
    public void schedule() {
        logger.info("BikeUsage scheduler starts");
        try {
            this.bikeUsageService.fetchData().subscribe(
                response -> {
                        logger.info("Sending bike usage data.");
                        mqSender.sendBikeUsageData(response);
                }
            );
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
