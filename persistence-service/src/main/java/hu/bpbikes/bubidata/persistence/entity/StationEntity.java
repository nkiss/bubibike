package hu.bpbikes.bubidata.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class StationEntity {
	
	@Id
	private String id;
	
	private String name;
	
	private Double longitude;
	private Double latitude;
	
	@OneToMany(mappedBy = "station", cascade = CascadeType.ALL)
	private List<StationSnapshot> snapshot = new ArrayList<>();
	
	public StationEntity() {};
	
	public StationEntity(String id, String name, Double longitude, Double latitude) {
		super();
		this.id = id;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public List<StationSnapshot> getSnapshot() {
		return snapshot;
	}

	public void setSnapshot(List<StationSnapshot> snapshot) {
		this.snapshot = snapshot;
	}
	
}
