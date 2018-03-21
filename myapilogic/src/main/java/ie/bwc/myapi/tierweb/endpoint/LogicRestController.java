package ie.bwc.myapi.tierweb.endpoint;

import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ie.bwc.myapi.models.Data;
import ie.bwc.myapi.tierservice.Logic;
import ie.bwc.myapi.tierservice.WebsocketClient;

/**
 * 
 * @author Kieran
 *
 */
@RestController
public class LogicRestController {
	
	@Autowired
	private Logic service;
	@Autowired
	private WebsocketClient client;

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public Data home() {
		return service.buildResult();
	}
	
	/**
	 * 
	 * @return
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 * @throws URISyntaxException 
	 * @throws TimeoutException 
	 */
	@RequestMapping("/callsocket")
	public String callsocket() throws InterruptedException, ExecutionException, TimeoutException, URISyntaxException {
		client.callSocket();
		return "hello";
	}
	
}