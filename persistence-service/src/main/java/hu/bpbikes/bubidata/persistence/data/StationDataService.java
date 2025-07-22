package hu.bpbikes.bubidata.persistence.data;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.bpbikes.bubidata.bikeusage.model.BikeUsage;
import hu.bpbikes.bubidata.bikeusage.model.Station;
import hu.bpbikes.bubidata.persistence.entity.Bike;
import hu.bpbikes.bubidata.persistence.entity.StationEntity;
import hu.bpbikes.bubidata.persistence.entity.StationSnapshot;

@Service
public class StationDataService {
	
	private static final Logger log = LoggerFactory.getLogger(StationDataService.class);
	
	private final StationRepository stationRepository;
	
	public StationDataService(StationRepository stationRepository) {
		this.stationRepository = stationRepository;
	}
	
	@Transactional
	public void saveSnapshot(BikeUsage bikeUsage) {
		log.info("Start saving bike usage.");
		List<Station> stationModels = bikeUsage.getNetwork().getStations();
		
		stationModels.forEach(dto -> {
			StationEntity station = stationRepository.findById(dto.getId())
					.orElse(new StationEntity(dto.getId(), 
										dto.getName(),
										dto.getLongitude(),
										dto.getLatitude()));
			
			StationSnapshot snapshot = new StationSnapshot();
			snapshot.setTimestamp(this.parseTimestamp(dto.getTimestamp()));
			snapshot.setFreeBikes(dto.getFreeBikes());
			snapshot.setEmptySlots(dto.getEmptySlots());
			snapshot.setTotalSlots(dto.getExtra().getSlots());
			snapshot.setStationUid(dto.getExtra().getUid());
			snapshot.setStationNumber(dto.getExtra().getNumber());
			
			List<Bike> bikes = dto.getExtra().getBikeUids()
					.stream()
					.map(uid -> new Bike(uid))
					.collect(Collectors.toList());
			
			snapshot.setBikes(bikes);
			snapshot.setStation(station);
			station.getSnapshot().add(snapshot);
			stationRepository.save(station);
		});
	}
	
	private Instant parseTimestamp(String timeStampText) {
		// Remove the redundant "Z" at the end if both "+00:00" and "Z" are present
        if (timeStampText.endsWith("+00:00Z")) {
        	timeStampText = timeStampText.replace("+00:00Z", "+00:00");
        }
        return OffsetDateTime.parse(timeStampText).toInstant();
	}
}
