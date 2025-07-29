package hu.bpbikes.bubidata.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.bpbikes.bubidata.persistence.entity.StationEntity;

public interface StationRepository extends JpaRepository<StationEntity, String> {}
