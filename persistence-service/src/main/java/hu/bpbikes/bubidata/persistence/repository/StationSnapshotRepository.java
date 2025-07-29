package hu.bpbikes.bubidata.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.bpbikes.bubidata.persistence.entity.StationSnapshot;

public interface StationSnapshotRepository extends JpaRepository<StationSnapshot, Long> {

	List<StationSnapshot> findTopByWeatherIsNullOrderByTimestampDesc();}
