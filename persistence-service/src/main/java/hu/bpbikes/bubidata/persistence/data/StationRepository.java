package hu.bpbikes.bubidata.persistence.data;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.bpbikes.bubidata.persistence.entity.StationEntity;

public interface StationRepository extends JpaRepository<StationEntity, String> {}
