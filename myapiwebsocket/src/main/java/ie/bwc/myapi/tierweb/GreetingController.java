package ie.bwc.myapi.tierweb;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import ie.bwc.myapi.models.SocketPayload;

/**
 * 
 * @author Kieran
 *
 */
@Controller
public class GreetingController {

	@Autowired
	private SimpMessagingTemplate broker;

	/**
	 * 
	 * @param user
	 * @param headerAccessor
	 * @param message
	 * @throws Exception
	 */
	@MessageMapping("/hello")
	@SendTo("/user/queue/greetings")
	public void greeting(Principal user, SimpMessageHeaderAccessor headerAccessor, SocketPayload message) throws Exception {
		System.out.println("Received: " + user + "][" + message.getContent() + "][" + headerAccessor.getSessionId());
		broker.convertAndSendToUser(user.getName(), "/queue/greetings", new SocketPayload("Hello, " + message.getContent() + "!"));
	}

}