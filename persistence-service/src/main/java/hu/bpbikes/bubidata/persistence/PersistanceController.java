package hu.bpbikes.bubidata.persistence;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersistanceController {
	
	
	@PostMapping("/addusage")
	public void addBikeUsage() {
		
	}
	
	@PostMapping("/addweather")
	public void addWeatherData() {
		
	}

}
