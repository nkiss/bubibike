package hu.bpbikes.bubidata.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WeatherUnit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String time;
	
	private String interval;
	
	private String temperature;
	
	private String relativeHumidity;
	
	private String apparentTemperature;
	
	private String day;
	
	private String rain;
	
	private String showers;
	
	private String snowfall;
	
	private String coudCover;
	
	private String windSpeed;
	
	private String windDirection;
	
	private String windGusts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
