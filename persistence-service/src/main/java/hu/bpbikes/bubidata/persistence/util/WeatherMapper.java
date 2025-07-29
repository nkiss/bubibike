package hu.bpbikes.bubidata.persistence.util;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.bpbikes.bubidata.persistence.entity.WeatherEntity;
import hu.bpbikes.bubidata.persistence.entity.WeatherUnit;
import hu.bpbikes.bubidata.weather.model.Units;
import hu.bpbikes.bubidata.weather.model.WeatherData;

@Mapper(componentModel = "spring")
public interface WeatherMapper {
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "unit", ignore = true)
    WeatherEntity toEntity(WeatherData dto);
    
    WeatherData toDto(WeatherEntity entity);
    
    @Mapping(target = "id", ignore = true)
    WeatherUnit toWeatherUnit(Units dto);

}