package hu.bpbikes.bubidata.bikeusage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Station {
    
	private String id;
    
    private String name;
    
    private double latitude;
    
    private double longitude;
  
    private String timestamp;
    
    @JsonProperty("free_bikes")
    private int freeBikes;
    
    @JsonProperty("empty_slots")
	private int emptySlots;
    
    private Extra extra;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public int getFreeBikes() { return freeBikes; }
    public void setFreeBikes(int freeBikes) { this.freeBikes = freeBikes; }

    public int getEmptySlots() { return emptySlots; }
    public void setEmptySlots(int emptySlots) { this.emptySlots = emptySlots; }

    public Extra getExtra() { return extra; }
    public void setExtra(Extra extra) { this.extra = extra; }
    
    @Override
	public String toString() {
		return "Station [id=" + id + ", name=" + name + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", timestamp=" + timestamp + ", freeBikes=" + freeBikes + ", emptySlots=" + emptySlots + ", extra="
				+ extra + "]";
	}
}