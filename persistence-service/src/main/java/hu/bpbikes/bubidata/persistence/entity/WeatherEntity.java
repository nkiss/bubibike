package hu.bpbikes.bubidata.persistence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "weather_data")
public class WeatherEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private LocalDateTime time;
	
	private Integer interval;
	
	private Double temperature;
	
	private Integer relativeHumidity;
	
	private Double apparentTemperature;
	
	private Boolean day;
	
	private Double rain;
	
	private Double showers;
	
	private Double snowFall;
	
	private Integer cloudCover;
	
	private Integer windSpeed;
	
	private Integer windDirection;
	
	private Integer windGusts;
	
	@ManyToOne
	@JoinColumn(name = "unit_id")
	private WeatherUnit unit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public WeatherUnit getUnit() {
		return unit;
	}

	public void setUnit(WeatherUnit unit) {
		this.unit = unit;
	}
	
}
