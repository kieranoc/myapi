package ie.bwc.myapi.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author Kieran
 *
 */
@ComponentScan({"ie.bwc.myapi.tierweb", "ie.bwc.myapi.config"})
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