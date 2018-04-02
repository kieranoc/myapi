package ie.bwc.myapi.config;

import java.net.URI;
import java.util.Arrays;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

/**
 * 
 * @author Kieran
 *
 */
@Configuration
@EnableJms
public class MQConfig {

	@Value("${activemq.broker-url}")
	private String brokerUrl;
	
	/**
     * This represents a JMS server. In this case, this is an embedded JMS server.
     * In production, you always connect to external JMS servers.
     *
     * @return
     * @throws Exception
     */
    @Bean
    public BrokerService createBrokerService() throws Exception {
        BrokerService broker = new BrokerService();
        TransportConnector connector = new TransportConnector();
        connector.setUri(new URI(brokerUrl));
        broker.addConnector(connector);
        return broker;
    }
    
    /**
     * 
     * @return
     */
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(brokerUrl);
        factory.setTrustedPackages(Arrays.asList("ie.bwc.myapi.models", "java.lang", "java.time"));
        factory.setRejectedTaskHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return factory;
    }

}