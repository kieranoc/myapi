package ie.bwc.myapi.tierservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import javax.annotation.PostConstruct;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import ie.bwc.myapi.models.SocketPayload;

import java.lang.reflect.Type;
import java.net.URISyntaxException;

/**
 * 
 * @author Kieran
 *
 */
@Service
public class WebsocketClient {
	
	private StompSession session;
	
	/**
	 * 
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@PostConstruct
	public void initialise() throws InterruptedException, ExecutionException {
		WebSocketClient webSocketClient = new StandardWebSocketClient();
		WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
		stompClient.setMessageConverter(new MappingJackson2MessageConverter());
		stompClient.setTaskScheduler(new ConcurrentTaskScheduler());

		String url = "ws://127.0.0.1:8082/hello";
		StompSessionHandler sessionHandler = new MySessionHandler();
		stompClient.connect(url, sessionHandler);
		session = stompClient.connect(url, sessionHandler).get();
	}

	/**
	 * 
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * @throws TimeoutException
	 * @throws URISyntaxException
	 */
	public void callSocket() throws InterruptedException, ExecutionException, TimeoutException, URISyntaxException {
		System.out.println("Client1 SessionID (client) = " + session.getSessionId());
		StompHeaders hds = new StompHeaders();
		hds.setDestination("/app/hello");
		session.send(hds, "{\"content\":\"Kieran\"}");
	}

	/**
	 * 
	 * @author Kieran
	 *
	 */
	public class MySessionHandler extends StompSessionHandlerAdapter {

		/**
		 * 
		 */
		@Override
		public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
			session.subscribe("/user/queue/greetings", this);
		}

		/**
		 * 
		 */
		@Override
		public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
			exception.printStackTrace();
		}

		/**
		 * 
		 */
		@Override
		public Type getPayloadType(StompHeaders headers) {
			return SocketPayload.class;
		}

		/**
		 * 
		 */
		@Override
		public void handleFrame(StompHeaders headers, Object payload) {
			System.out.println("Client1 Received: " + ((SocketPayload) payload).getContent()  + "....." + headers.keySet() + "]......[" + headers.entrySet());
		}
	}
}