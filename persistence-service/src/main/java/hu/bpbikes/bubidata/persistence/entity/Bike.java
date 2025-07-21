package hu.bpbikes.bubidata.persistence.entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;

@Entity
public class Bike {
	
	@Id
	private String uuid;

	public Bike(String uuid) {
		super();
		this.uuid = uuid;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
