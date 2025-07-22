package hu.bpbikes.bubidata.weather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    private Double latitude;
    private Double longitude;
    @JsonProperty("current_units")
    private Units units;
    @JsonProperty("current")
    private WeatherData weatherData;
    
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Units getUnits() {
		return units;
	}
	public void setUnits(Units units) {
		this.units = units;
	}
	public WeatherData getWeatherData() {
		return weatherData;
	}
	public void setWeatherData(WeatherData weatherData) {
		this.weatherData = weatherData;
	}

	@Override
	public String toString() {
		return "Weather [latitude=" + latitude + ", longitude=" + longitude + ", units=" + units + ", weatherData="
				+ weatherData + "]";
	}
}
