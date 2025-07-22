package hu.bpbikes.bubidata.persistence.data;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.bpbikes.bubidata.persistence.entity.WeatherEntity;
import hu.bpbikes.bubidata.persistence.entity.WeatherUnit;
import hu.bpbikes.bubidata.weather.model.Units;
import hu.bpbikes.bubidata.weather.model.Weather;

@Service
public class WeatherDataService {

	private static final Logger log = LoggerFactory.getLogger(WeatherDataService.class);

	private WeatherRepository weatherRepository;

	private WeatherUnitRepository weatherUnitRepository;

	public WeatherDataService(final WeatherRepository weatherRepository,
			final WeatherUnitRepository weatherUnitRepository) {
		this.weatherRepository = weatherRepository;
		this.weatherUnitRepository = weatherUnitRepository;
	}

	@Transactional
	public void saveWeatherData(Weather dto) {
		// only one elements of units is stored
		Optional<WeatherUnit> weatherUnit = weatherUnitRepository.findTopByOrderByIdDesc();
		weatherUnit.ifPresentOrElse(
				existing -> log.debug("Has weather units data"),
				() -> this.weatherUnitRepository.save(weatherUnitsMapper(dto.getUnits())));

		// if there is already a weather data for a specific time then no save
		this.weatherRepository.findByTime(dto.getWeatherData().getTime())
				.ifPresentOrElse(
						existing -> log.info("WeatherData already exists for {}", existing.getTime()), 
						() -> {
							WeatherEntity weatherEntity = weatherMapper(dto);
							weatherUnit.ifPresent(weatherEntity::setUnit);
							this.weatherRepository.save(weatherEntity);
						});
	}

	private WeatherUnit weatherUnitsMapper(Units dto) {
		WeatherUnit unit = new WeatherUnit();
		unit.setApparentTemperature(dto.getApparentTemperature());
		unit.setCoudCover(dto.getCoudCover());
		unit.setDay(dto.getDay());
		unit.setInterval(dto.getInterval());
		unit.setRain(dto.getRain());
		unit.setRelativeHumidity(dto.getRelativeHumidity());
		unit.setShowers(dto.getShowers());
		unit.setSnowfall(dto.getSnowfall());
		unit.setTemperature(dto.getTemperature());
		unit.setTime(dto.getTime());
		unit.setWindDirection(dto.getWindDirection());
		unit.setWindGusts(dto.getWindGusts());
		unit.setWindSpeed(dto.getWindSpeed());
		return unit;
	}

	private WeatherEntity weatherMapper(Weather dto) {
		WeatherEntity weatherEntity = new WeatherEntity();
		weatherEntity.setApparentTemperature(dto.getWeatherData().getApparentTemperature());
		weatherEntity.setRain(dto.getWeatherData().getRain());
		weatherEntity.setCloudCover(dto.getWeatherData().getCloudCover());
		weatherEntity.setDay(dto.getWeatherData().getDay());
		weatherEntity.setInterval(dto.getWeatherData().getInterval());
		weatherEntity.setRelativeHumidity(dto.getWeatherData().getRelativeHumidity());
		weatherEntity.setShowers(dto.getWeatherData().getShowers());
		weatherEntity.setSnowFall(dto.getWeatherData().getSnowFall());
		weatherEntity.setTemperature(dto.getWeatherData().getTemperature());
		weatherEntity.setTime(dto.getWeatherData().getTime());
		weatherEntity.setWindDirection(dto.getWeatherData().getWindDirection());
		weatherEntity.setWindGusts(dto.getWeatherData().getWindGusts());
		weatherEntity.setWindSpeed(dto.getWeatherData().getWindSpeed());
		return weatherEntity;
	}

}
