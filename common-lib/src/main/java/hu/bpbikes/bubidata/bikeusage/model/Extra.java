package hu.bpbikes.bubidata.bikeusage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Extra {
    private String uid;
    private String number;
    private int slots;

    @JsonProperty("bike_uids")
    private List<String> bikeUids;

    // Getters and Setters
    public String getUid() { return uid; }
    public void setUid(String uid) { this.uid = uid; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public int getSlots() { return slots; }
    public void setSlots(int slots) { this.slots = slots; }

    public List<String> getBikeUids() { return bikeUids; }
    public void setBikeUids(List<String> bikeUids) { this.bikeUids = bikeUids; }
}