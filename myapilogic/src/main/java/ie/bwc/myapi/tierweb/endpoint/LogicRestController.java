package ie.bwc.myapi.tierweb.endpoint;

import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ie.bwc.myapi.models.Data;
import ie.bwc.myapi.tierservice.Logic;
import ie.bwc.myapi.tierservice.MQClient;
import ie.bwc.myapi.tierservice.WebsocketClient;

/**
 * 
 * @author Kieran
 *
 */
@RestController
public class LogicRestController {

	@Autowired
	private Logic httpRestClient;
	@Autowired
	private WebsocketClient websocketClient;
	@Autowired
	private MQClient mqClient;

	/**
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public Data home() {
		return httpRestClient.buildResult();
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
		websocketClient.callSocket();
		return "hello";
	}

	/**
	 * 
	 */
	@RequestMapping("/callmq")
	public void callmq() {
		Data d = Data.builder().withId(1).withSomething("test").withTimestamp(LocalDateTime.now()).build();
		mqClient.send("mailbox", d);
	}
	
}