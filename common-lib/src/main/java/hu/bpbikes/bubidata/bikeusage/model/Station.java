package hu.bpbikes.bubidata.bikeusage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class Station {
    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private String timestamp;
    private int freeBikes;
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
}