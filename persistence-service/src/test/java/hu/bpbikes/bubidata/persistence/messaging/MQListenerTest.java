package hu.bpbikes.bubidata.persistence.messaging;


import hu.bpbikes.bubidata.bikeusage.model.BikeUsage;
import hu.bpbikes.bubidata.persistence.data.StationDataService;
import hu.bpbikes.bubidata.persistence.data.WeatherDataService;
import hu.bpbikes.bubidata.weather.model.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MQListenerTest {

    private StationDataService stationDataService;
    private WeatherDataService weatherDataService;
    private MQListener mqListener;

    @BeforeEach
    void setUp() {
        stationDataService = mock(StationDataService.class);
        weatherDataService = mock(WeatherDataService.class);
        mqListener = new MQListener(stationDataService, weatherDataService);
    }

    @Test
    void receiveWeatherData_shouldSaveWeatherAndUpdateSnapshots() {
        Weather weather = new Weather();

        mqListener.receiveWeatherData(weather);

        verify(weatherDataService).saveWeatherData(weather);
        verify(stationDataService).updateSnapshots();
    }

    @Test
    void receiveBikeUsageData_shouldSaveSnapshot() {
        BikeUsage bikeUsage = new BikeUsage();

        mqListener.receiveBikeUsageData(bikeUsage);

        verify(stationDataService).saveSnapshot(bikeUsage);
    }
}
