package hu.bpbikes.bubidata.persistence.data;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.bpbikes.bubidata.persistence.entity.WeatherEntity;
import hu.bpbikes.bubidata.persistence.entity.WeatherUnit;
import hu.bpbikes.bubidata.persistence.repository.WeatherRepository;
import hu.bpbikes.bubidata.persistence.repository.WeatherUnitRepository;
import hu.bpbikes.bubidata.persistence.util.WeatherMapper;
import hu.bpbikes.bubidata.weather.model.Weather;

@Service
public class WeatherDataService {

	private static final Logger log = LoggerFactory.getLogger(WeatherDataService.class);

	private WeatherRepository weatherRepository;

	private WeatherUnitRepository weatherUnitRepository;
	
	private WeatherMapper weatherMapper;

	public WeatherDataService(
			final WeatherRepository weatherRepository,
			final WeatherUnitRepository weatherUnitRepository,
			final WeatherMapper weatherMapper) {
		this.weatherRepository = weatherRepository;
		this.weatherUnitRepository = weatherUnitRepository;
		this.weatherMapper = weatherMapper;
	}

	@Transactional
	public void saveWeatherData(Weather dto) {
		// only one elements of units is stored
		Optional<WeatherUnit> weatherUnit = weatherUnitRepository.findTopByOrderByIdDesc();
		weatherUnit.ifPresentOrElse(
				existing -> log.debug("Has weather units data"),
				() -> this.weatherUnitRepository.save(weatherMapper.toWeatherUnit(dto.getUnits())));

		// if there is already a weather data for a specific time then no save
		this.weatherRepository.findByTime(dto.getWeatherData().getTime())
				.ifPresentOrElse(
						existing -> log.info("WeatherData already exists for {}", existing.getTime()), 
						() -> {
							WeatherEntity weatherEntity = weatherMapper.toEntity(dto.getWeatherData());
							weatherUnit.ifPresent(weatherEntity::setUnit);
							this.weatherRepository.save(weatherEntity);
						});
	}

}
