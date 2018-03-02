package ie.bwc.myapi.tierweb.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ie.bwc.myapi.models.Data;
import ie.bwc.myapi.tierservice.Logic;

/**
 * 
 * @author Kieran
 *
 */
@RestController
public class LogicRestController {
	
	@Autowired
	private Logic service;

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public Data home() {
		return service.buildResult();
	}
	
}