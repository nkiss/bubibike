package hu.bpbikes.bubidata.persistence.data;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.bpbikes.bubidata.persistence.entity.Bike;

public interface BikeRepository extends JpaRepository<Bike, String> {}
