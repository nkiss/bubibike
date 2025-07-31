package hu.bpbikes.bubidata.collector.weather;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import hu.bpbikes.bubidata.weather.model.Weather;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {

	private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);

	@Qualifier("weatherApiWebClient")
	private final WebClient webClient;

	private final OpenMeteoProps openMeteoProps;

	public WeatherService(WebClient webClient, final OpenMeteoProps openMeteoProps) {
		this.webClient = webClient;
		this.openMeteoProps = openMeteoProps;
	}

	public Mono<Weather> fetchData() {
		logger.debug("Calling Open Meteo for wheather information");

		String uri = UriComponentsBuilder
						.fromUriString(openMeteoProps.getBase()
						.concat(openMeteoProps.getVersion())
						.concat(openMeteoProps.getEndpoint()))
				.queryParam(OpenMeteoParams.LATITUDE.name().toLowerCase(), openMeteoProps.getLatitude())
				.queryParam(OpenMeteoParams.LONGITUDE.name().toLowerCase(), openMeteoProps.getLongitude())
				.queryParam(OpenMeteoParams.CURRENT.name().toLowerCase(), openMeteoProps.getCurrent())
				.queryParam(OpenMeteoParams.TIMEZONE.name().toLowerCase(), openMeteoProps.getTimezone())
				.queryParam(OpenMeteoParams.FORECAST_DAYS.name().toLowerCase(), openMeteoProps.getForecast_days())
				.build().toUriString();
		logger.debug("OpenMeteo built url: {}", uri);

		return webClient.get()
				.uri(uri)
				.retrieve().bodyToMono(Weather.class)
				.timeout(Duration.ofSeconds(5))
				.doOnSuccess(response -> {
					logger.debug("Successfully fetched weather data from Open Meteo");
				}).doOnError(throwable -> logger.error("Failed to fetch weather data from Open Meteo API", throwable))
				.log();
				
	}

}
