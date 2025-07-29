package hu.bpbikes.bubidata.persistence.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import hu.bpbikes.bubidata.persistence.entity.WeatherEntity;
import hu.bpbikes.bubidata.weather.model.WeatherData;

@SpringBootTest
@ActiveProfiles("test")
public class WeatherMapperTest {

	private static final int ZERO = 0;
	
	@Autowired
	private WeatherMapper weatherMapper;
	
	@Test
	public void testMapping_positive() {
		
		WeatherData weatherData = new WeatherData();
		weatherData.setApparentTemperature(Double.MAX_VALUE);
		weatherData.setCloudCover(Integer.MAX_VALUE);
		weatherData.setDay(Boolean.TRUE);
		weatherData.setInterval(Integer.valueOf(ZERO));
		weatherData.setRain(Double.valueOf(1.10));
		weatherData.setRelativeHumidity(Integer.valueOf(1));
		weatherData.setShowers(Double.valueOf(ZERO));
		weatherData.setSnowFall(Double.valueOf(ZERO));
		weatherData.setTemperature(Double.valueOf(20));
		weatherData.setTime(LocalDateTime.now());
		weatherData.setWindDirection(Integer.valueOf(ZERO));
		weatherData.setWindGusts(Integer.valueOf(ZERO));
		weatherData.setWindSpeed(Integer.valueOf(ZERO));
		
		WeatherEntity entity = weatherMapper.toEntity(weatherData);
		assertNotNull(entity);
		
		assertEquals(weatherData.getApparentTemperature(), entity.getApparentTemperature());
		assertEquals(weatherData.getCloudCover(), entity.getCloudCover());
		assertEquals(weatherData.getDay(), entity.getDay());
		assertEquals(weatherData.getInterval(), entity.getInterval());
		assertEquals(weatherData.getRain(), entity.getRain());
		assertEquals(weatherData.getRelativeHumidity(), entity.getRelativeHumidity());
		assertEquals(weatherData.getShowers(), entity.getShowers());
		assertEquals(weatherData.getSnowFall(), entity.getSnowFall());
		assertEquals(weatherData.getTemperature(), entity.getTemperature());
		assertEquals(weatherData.getTime(), entity.getTime());
		assertEquals(weatherData.getWindDirection(), entity.getWindDirection());
		assertEquals(weatherData.getWindGusts(), entity.getWindGusts());
		assertEquals(weatherData.getWindSpeed(), entity.getWindSpeed());
	}

}
