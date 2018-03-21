package ie.bwc.myapi.config;

import java.security.Principal;
import java.util.Map;
import java.util.UUID;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

/**
 * 
 * @author Kieran
 *
 */
@Configuration
@EnableWebSocketMessageBroker
@EnableScheduling
public class WebsocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	/**
	 * 
	 */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/queue", "/user");
		config.setApplicationDestinationPrefixes("/app");
		config.setUserDestinationPrefix("/user");
	}

	/**
	 * 
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/hello").setHandshakeHandler(new CustomHandshakeHandler());
	}

	/**
	 * 
	 * @author Kieran
	 *
	 */
	class CustomHandshakeHandler extends DefaultHandshakeHandler {
		/**
		 * Custom class for storing principal
		 */
		@Override
		protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
			// Generate principal with UUID as name
			return new StompPrincipal(UUID.randomUUID().toString());
		}
	}

	/**
	 * 
	 * @author Kieran
	 *
	 */
	class StompPrincipal implements Principal {
		String name;

		/**
		 * 
		 * @param name
		 */
		StompPrincipal(String name) {
			this.name = name;
		}

		/**
		 * 
		 */
		@Override
		public String getName() {
			return name;
		}
	}
	
}