package hu.bpbikes.bubidata.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Units {

	/*
	"time": "iso8601",
    "interval": "seconds",
    "temperature_2m": "°C",
    "relative_humidity_2m": "%",
    "apparent_temperature": "°C",
    "is_day": "",
    "rain": "mm",
    "showers": "mm",
    "snowfall": "cm",
    "cloud_cover": "%",
    "wind_speed_10m": "km/h",
    "wind_direction_10m": "°",
    "wind_gusts_10m": "km/h"
	 */
	private String time;
	
	private String interval;
	
	@JsonProperty("temperature_2m")
	private String temperature;
	
	@JsonProperty("relative_humidity_2m")
	private String relativeHumidity;
	
	@JsonProperty("apparent_temperature")
	private String apparentTemperature;
	
	@JsonProperty("is_day")
	private String day;
	
	private String rain;
	
	private String showers;
	
	private String snowfall;
	
	private String coudCover;
	
	@JsonProperty("wind_speed_10m")
	private String windSpeed;
	
	@JsonProperty("wind_direction_10m")
	private String windDirection;
	
	@JsonProperty("wind_gusts_10m")
	private String windGusts;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getInterval() {
		return interval;
	}

	public void setInterval(String interval) {
		this.interval = interval;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(String relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	public String getApparentTemperature() {
		return apparentTemperature;
	}

	public void setApparentTemperature(String apparentTemperature) {
		this.apparentTemperature = apparentTemperature;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getRain() {
		return rain;
	}

	public void setRain(String rain) {
		this.rain = rain;
	}

	public String getShowers() {
		return showers;
	}

	public void setShowers(String showers) {
		this.showers = showers;
	}

	public String getSnowfall() {
		return snowfall;
	}

	public void setSnowfall(String snowfall) {
		this.snowfall = snowfall;
	}

	public String getCoudCover() {
		return coudCover;
	}

	public void setCoudCover(String coudCover) {
		this.coudCover = coudCover;
	}

	public String getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(String windSpeed) {
		this.windSpeed = windSpeed;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public String getWindGusts() {
		return windGusts;
	}

	public void setWindGusts(String windGusts) {
		this.windGusts = windGusts;
	}
	
}
