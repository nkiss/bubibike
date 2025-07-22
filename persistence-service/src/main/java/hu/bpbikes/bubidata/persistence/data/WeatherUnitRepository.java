package hu.bpbikes.bubidata.persistence.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import hu.bpbikes.bubidata.persistence.entity.WeatherUnit;

public interface WeatherUnitRepository extends CrudRepository<WeatherUnit, Long> {
	
	Optional<WeatherUnit> findTopByOrderByIdDesc();

}
