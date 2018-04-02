package ie.bwc.myapi.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author Kieran
 *
 */
@EnableDiscoveryClient
@ComponentScan({"ie.bwc.myapi.config", "ie.bwc.myapi.tierservice"})
@SpringBootApplication
public class TomcatApp {

	/**
	 * 
	 * @param args
	 */
    public static void main(String[] args) {
        SpringApplication.run(TomcatApp.class, args);
    }

}