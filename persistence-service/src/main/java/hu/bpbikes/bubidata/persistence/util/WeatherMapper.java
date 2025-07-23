package hu.bpbikes.bubidata.persistence.util;

import org.mapstruct.Mapper;

import hu.bpbikes.bubidata.persistence.entity.WeatherEntity;
import hu.bpbikes.bubidata.persistence.entity.WeatherUnit;
import hu.bpbikes.bubidata.weather.model.Units;
import hu.bpbikes.bubidata.weather.model.Weather;
import hu.bpbikes.bubidata.weather.model.WeatherData;

@Mapper(componentModel = "spring")
public interface WeatherMapper {
	
    WeatherEntity toEntity(WeatherData dto);
    
    Weather toDto(WeatherEntity entity);
    
    WeatherUnit toWeatherUnit(Units dto);

}