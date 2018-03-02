package ie.bwc.myapi.tierweb.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ie.bwc.myapi.models.Data;
import ie.bwc.myapi.tierservice.Logic2;

/**
 * 
 * @author Kieran
 *
 */
@RestController
public class Logic2RestController {
	
	@Autowired
	private Logic2 service;

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public Data home() {
		return service.buildResult();
	}
	
}