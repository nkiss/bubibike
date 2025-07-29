package hu.bpbikes.bubidata.collector.bikeusage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "citybik.api")
public class BikeUsageProps {
	
	private String base;
	private String endpoint;
	private int timeout;

	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

}
