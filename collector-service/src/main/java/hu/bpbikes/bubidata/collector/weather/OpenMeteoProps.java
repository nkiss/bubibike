package hu.bpbikes.bubidata.collector.weather;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "openmeteo.api")
public class OpenMeteoProps {
	
	private String base;
	private String version;
	private String endpoint;
	private Double latitude;
	private Double longitude;
	private String current;
	private String timezone;
	private Integer forecast_days;

	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
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
	public String getCurrent() {
		return current;
	}
	public void setCurrent(String current) {
		this.current = current;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public Integer getForecast_days() {
		return forecast_days;
	}
	public void setForecast_days(Integer forecast_days) {
		this.forecast_days = forecast_days;
	}

}
