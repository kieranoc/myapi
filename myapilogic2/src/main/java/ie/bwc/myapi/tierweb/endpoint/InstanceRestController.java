package ie.bwc.myapi.tierweb.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Kieran
 *
 */
@RestController
public class InstanceRestController {

	@Autowired
	private DiscoveryClient discoveryClient;

	/**
	 * 
	 * @param applicationName
	 * @return
	 */
	@RequestMapping("/instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}
	
}