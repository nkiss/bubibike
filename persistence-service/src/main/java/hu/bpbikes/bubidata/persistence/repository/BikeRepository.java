package hu.bpbikes.bubidata.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.bpbikes.bubidata.persistence.entity.Bike;

public interface BikeRepository extends JpaRepository<Bike, String> {}
