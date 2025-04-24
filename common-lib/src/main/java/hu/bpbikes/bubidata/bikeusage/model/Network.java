package hu.bpbikes.bubidata.bikeusage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Network {
    private String id;
    private String name;
    private Location location;
    private String href;
    private List<String> company;
    private String system;
    private List<Station> stations;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Location getLocation() { return location; }
    public void setLocation(Location location) { this.location = location; }

    public String getHref() { return href; }
    public void setHref(String href) { this.href = href; }

    public List<String> getCompany() { return company; }
    public void setCompany(List<String> company) { this.company = company; }

    public String getSystem() { return system; }
    public void setSystem(String system) { this.system = system; }

    public List<Station> getStations() { return stations; }
    public void setStations(List<Station> stations) { this.stations = stations; }
}
