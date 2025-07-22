package hu.bpbikes.bubidata.persistence.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class StationSnapshot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Instant timestamp;
	
	private Integer freeBikes;
	private Integer emptySlots;
	private Integer totalSlots;
	
	private String stationUid;
	private String stationNumber;
	
	@ManyToOne
	@JoinColumn(name = "station_id")
	private StationEntity station;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "snapshot_bike",
			joinColumns = @JoinColumn(name = "snapshot_id"),
			inverseJoinColumns = @JoinColumn(name = "bike_id")
	)
	private List<Bike> bikes = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getFreeBikes() {
		return freeBikes;
	}

	public void setFreeBikes(Integer freeBikes) {
		this.freeBikes = freeBikes;
	}

	public Integer getEmptySlots() {
		return emptySlots;
	}

	public void setEmptySlots(Integer emptySlots) {
		this.emptySlots = emptySlots;
	}

	public Integer getTotalSlots() {
		return totalSlots;
	}

	public void setTotalSlots(Integer totalSlots) {
		this.totalSlots = totalSlots;
	}

	public String getStationUid() {
		return stationUid;
	}

	public void setStationUid(String stationUid) {
		this.stationUid = stationUid;
	}

	public String getStationNumber() {
		return stationNumber;
	}

	public void setStationNumber(String stationNumber) {
		this.stationNumber = stationNumber;
	}

	public StationEntity getStation() {
		return station;
	}

	public void setStation(StationEntity station) {
		this.station = station;
	}

	public List<Bike> getBikes() {
		return bikes;
	}

	public void setBikes(List<Bike> bikes) {
		this.bikes = bikes;
	}
	
}
