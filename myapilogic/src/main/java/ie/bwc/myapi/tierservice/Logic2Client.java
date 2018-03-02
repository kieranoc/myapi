package ie.bwc.myapi.tierservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import ie.bwc.myapi.models.Data;

/**
 * 
 * @author Kieran
 *
 */
@FeignClient("myapilogic2")
public interface Logic2Client {
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/")
    Data get();

}