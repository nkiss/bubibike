package hu.bpbikes.bubidata.weather.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class WeatherData {

	/*
	 "time": "2025-04-15T12:15",
    "interval": 900,
    "temperature_2m": 13.6,
    "relative_humidity_2m": 93,
    "apparent_temperature": 12.4,
    "is_day": 1,
    "rain": 0.20,
    "showers": 0.00,
    "snowfall": 0.00,
    "cloud_cover": 100,
    "wind_speed_10m": 13.0,
    "wind_direction_10m": 162,
    "wind_gusts_10m": 26.6
	 */
	
	private LocalDateTime time;
	
	private Integer interval;
	
	@JsonProperty("temperature_2m")
	private Double temperature;
	
	@JsonProperty("relative_humidity_2m")
	private Integer relativeHumidity;
	
	@JsonProperty("apparent_temperature")
	private Double apparentTemperature;
	
	@JsonProperty("is_day")
	@JsonDeserialize(using = hu.bpbikes.bubidata.serializer.IntToBooleanDeserializer.class)
	private Boolean day;
	
	private Double rain;
	
	private Double showers;
	
	@JsonProperty("snowfall")
	private Double snowFall;
	
	@JsonProperty("colud_cover")
	private Integer cloudCover;
	
	@JsonProperty("wind_speed_10m")
	private Integer windSpeed;
	
	@JsonProperty("wind_direction_10m")
	private Integer windDirection;
	
	@JsonProperty("wind_gusts_10m")
	private Integer windGusts;

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Integer getInterval() {
		return interval;
	}

	public void setInterval(Integer interval) {
		this.interval = interval;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Integer getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(Integer relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	public Double getApparentTemperature() {
		return apparentTemperature;
	}

	public void setApparentTemperature(Double apparentTemperature) {
		this.apparentTemperature = apparentTemperature;
	}

	public Boolean getDay() {
		return day;
	}

	public void setDay(Boolean day) {
		this.day = day;
	}

	public Double getRain() {
		return rain;
	}

	public void setRain(Double rain) {
		this.rain = rain;
	}

	public Double getShowers() {
		return showers;
	}

	public void setShowers(Double showers) {
		this.showers = showers;
	}

	public Double getSnowFall() {
		return snowFall;
	}

	public void setSnowFall(Double snowFall) {
		this.snowFall = snowFall;
	}

	public Integer getCloudCover() {
		return cloudCover;
	}

	public void setCloudCover(Integer cloudCover) {
		this.cloudCover = cloudCover;
	}

	public Integer getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Integer windSpeed) {
		this.windSpeed = windSpeed;
	}

	public Integer getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(Integer windDirection) {
		this.windDirection = windDirection;
	}

	public Integer getWindGusts() {
		return windGusts;
	}

	public void setWindGusts(Integer windGusts) {
		this.windGusts = windGusts;
	}
	
}
