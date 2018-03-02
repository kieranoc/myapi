package ie.bwc.myapi.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author Kieran
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApp {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(EurekaApp.class, args);
	}
	
}