package hu.bpbikes.bubidata.persistence.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.bpbikes.bubidata.persistence.entity.WeatherEntity;

public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {

	Optional<WeatherEntity> findByTime(LocalDateTime time);

	Optional<WeatherEntity> findTopByOrderByTimeDesc();

}
