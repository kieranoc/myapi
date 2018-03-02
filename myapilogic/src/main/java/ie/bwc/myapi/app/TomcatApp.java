package ie.bwc.myapi.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author Kieran
 *
 */
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"ie.bwc.myapi.tierservice"})
@ComponentScan({"ie.bwc.myapi.tierweb", "ie.bwc.myapi.config", "ie.bwc.myapi.tierservice"})
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